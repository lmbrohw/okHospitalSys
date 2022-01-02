package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.DoctorService;
import com.fightlandlord.sys_back.util.Response;
import com.fightlandlord.sys_back.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorRouterController {


    @Autowired
    DoctorService doctorService;
    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAPatient")
    public Register getAPatient(String doctorId){

        return doctorService.getAPatient(doctorId);
    }

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:11
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getPatientRecord")
    public List<DossierTable> getPatientRecord(String patientId){

        return doctorService.getPatientRecord(patientId);
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getMedcineList")
    public List<MedicineList> getMedcineList(){

        return doctorService.getMedicineList();
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getCheckList")
    public List<CheckList> getCheckList(){

        return doctorService.getCheckList();
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendDossierTable")
    public Response sendDossierTable(String doctorId, String patientId, String description){

        DossierTable dossierTable = new DossierTable();
        dossierTable.setDossierTableId(UUIDGenerator.makeUUID("DT"));
        dossierTable.setDoctorId(doctorId);
        dossierTable.setPatientId(patientId);
        dossierTable.setDescription(description);
        int Count = doctorService.sendDossierTable(dossierTable);
        System.out.println("Count____________" +Count);
        if(Count != 1)
            return Response.error().message("失败");

        else
            return Response.ok().message("病历上传成功");
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendCheckTable")
    public String sendCheckTable(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        JSONObject checkItems = jsonObject.getJSONObject("checkTable");

        CheckTable checkTable = new CheckTable();
        String checkTableId = UUIDGenerator.makeUUID("CT");
        checkTable.setCheckTableId(checkTableId);
        checkTable.setPatientId(jsonObject.getString("patientId"));
        checkTable.setDoctorId(jsonObject.getString("doctorId"));
        //计算 totalprice
        float sum= 0f;
        for(String i : checkItems.keySet()){
            sum += doctorService.getCheckItemPriceById(i) * checkItems.getIntValue(i);
        }
        checkTable.setTotalPrice(sum);
        int Count = doctorService.sendCheckTable(checkTable);

        //把检查项目信息insert到checkTableArray
        for(String i : checkItems.keySet()){
            CheckTableArray checkTableArray = new CheckTableArray();
            checkTableArray.setCheckTableArrayId(UUIDGenerator.makeUUID("CTA"));
            checkTableArray.setCheckTableId(checkTableId);
            checkTableArray.setCheckListId(i);
            int a = doctorService.addCheckTableArray(checkTableArray);
        }
        return "send";


    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendMedicineTable")
    public String sendMedicineTable(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        JSONObject medicineItems = jsonObject.getJSONObject("medicineTable");


        MedicineTable medicineTable = new MedicineTable();
        String medicineTableId = UUIDGenerator.makeUUID("MT");
        medicineTable.setMedicineTableId(medicineTableId);
        medicineTable.setPatientId(jsonObject.getString("patientId"));
        medicineTable.setDoctorId(jsonObject.getString("doctorId"));
        medicineTable.setPharmacistId(null);
        medicineTable.setDispenserId(null);
        //计算 totalprice
        float sum= 0f;
        for(String i : medicineItems.keySet()){
            sum += doctorService.getMedicinePriceById(i) * medicineItems.getIntValue(i);
        }
        medicineTable.setTotalPrice(sum);
        medicineTable.setMedicineTableState(0);
        int Count = doctorService.sendMedicineTable(medicineTable);

        //把处方单的药品信息insert到medicineTableArray
        for(String i : medicineItems.keySet()){
            sum += doctorService.getMedicinePriceById(i) * medicineItems.getIntValue(i);
            MedicineTableArray medicineTableArray = new MedicineTableArray();
            medicineTableArray.setMedicineTableArrayId(UUIDGenerator.makeUUID("MTA"));
            medicineTableArray.setMedicineTableId(medicineTableId);
            medicineTableArray.setMedicineListId(i);
            medicineTableArray.setMedicineNum(medicineItems.getIntValue(i));
            int a = doctorService.addMedicineTableArray(medicineTableArray);
        }
        return "sendMedicineTable";
    }
}
