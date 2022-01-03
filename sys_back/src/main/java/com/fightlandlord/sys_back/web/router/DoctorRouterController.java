package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.*;
import com.fightlandlord.sys_back.util.Response;
import com.fightlandlord.sys_back.util.UUIDGenerator;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorRouterController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    CheckTableService checkTableService;
    @Autowired
    CheckListService checkListService;
    @Autowired
    MedicineListService medicineListService;
    @Autowired
    MedicineTableService medicineTableService;
    @Autowired
    PatientService patientService;
    @Autowired
    DossierTableService dossierTableService;
    @Autowired
    CheckTableArrayService checkTableArrayService;
    @Autowired
    MedicineTableArrayService medicineTableArrayService;
    @Autowired
    RegisterService registerService;
    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAPatient")
    public Response getAPatient(String doctorId){

        Register register = patientService.getAPatient(doctorId);
        if (register == null)
            return Response.error().message("没有正在等待的病人");
        else
            return Response.ok().message("获取成功").data("patientInfo", register);
    }

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:11
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getPatientRecord")
    public Response getPatientRecord(String patientId){
        List<Register> registeRecords = registerService.getRegisterByPatientId(patientId);
        List<Map<String, Object>> allRecords = new LinkedList<>();

        for (Register registeRecord :registeRecords){
            Map<String,Object> oneTreatmentInfo = new HashMap<>();
            Date time = registeRecord.getRegisterTime();
            String doctorId = registeRecord.getRegisterChoice();
            DossierTable dossierTableRecord = dossierTableService.getDossierTableRecordById(registeRecord.getDossierTableId());
            Map<String, Object> medicineTableRecord = medicineTableService.getMedicineTableJSON(medicineTableService.queryById(registeRecord.getMedicineTableId()));
            Map<String, Object> checkTableRecord = checkTableService.getCheckTableJSON((checkTableService.queryById(registeRecord.getCheckTableId())));
            oneTreatmentInfo.put("time", time);
            oneTreatmentInfo.put("doctorId", doctorId);
            oneTreatmentInfo.put("dossierTable", dossierTableRecord);
            oneTreatmentInfo.put("medicineTable", medicineTableRecord);
            oneTreatmentInfo.put("checkTable", checkTableRecord);
            allRecords.add(oneTreatmentInfo);
        }

        return Response.ok().message("查询成功").data("treatmentInfoList", allRecords);
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getMedcineList")
    public Response getMedcineList(){

        return Response.ok().message("查询成功").data("medicineListInfo", medicineListService.getMedicineList());
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getCheckList")
    public Response getCheckList(){

        return Response.ok().message("查询成功").data("checkListInfo",checkListService.getCheckList());
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
        dossierTable.setDossierTableId(UUIDGenerator.makeUUID("dt"));
        dossierTable.setDoctorId(doctorId);
        dossierTable.setPatientId(patientId);
        dossierTable.setDescription(description);
        int Count = dossierTableService.sendDossierTable(dossierTable);
        if(Count == -1)
            return Response.error().message("上传出错，请检查病历信息");
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
    public Response sendCheckTable(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        JSONObject checkItems = jsonObject.getJSONObject("checkTable");
        CheckTable checkTable = new CheckTable();
        String checkTableId = UUIDGenerator.makeUUID("ct");
        checkTable.setCheckTableId(checkTableId);
        checkTable.setPatientId(jsonObject.getString("patientId"));
        checkTable.setDoctorId(jsonObject.getString("doctorId"));
        //计算 totalprice
        float sum= 0f;
        for(String i : checkItems.keySet()){
            sum += checkListService.getCheckItemPriceById(i) * checkItems.getIntValue(i);
        }
        checkTable.setTotalPrice(sum);
        int Count = checkTableService.sendCheckTable(checkTable);
        if (Count == -1)
            return Response.error().message("上传出错，请检查申请单信息");
        else
            //把检申请项目信息insert到checkTableArray
            for(String i : checkItems.keySet()){
                CheckTableArray checkTableArray = new CheckTableArray();
                checkTableArray.setCheckTableArrayId(UUIDGenerator.makeUUID("cta"));
                checkTableArray.setCheckTableId(checkTableId);
                checkTableArray.setCheckListId(i);
                int a = checkTableArrayService.addCheckTableArray(checkTableArray);
            }
            return Response.ok().message("上传成功");
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendMedicineTable")
    public Response sendMedicineTable(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        JSONObject medicineItems = jsonObject.getJSONObject("medicineTable");

        MedicineTable medicineTable = new MedicineTable();
        String medicineTableId = UUIDGenerator.makeUUID("mt");
        medicineTable.setMedicineTableId(medicineTableId);
        medicineTable.setPatientId(jsonObject.getString("patientId"));
        medicineTable.setDoctorId(jsonObject.getString("doctorId"));
        //计算 totalprice
        float sum= 0f;
        for(String i : medicineItems.keySet()){
            sum += medicineListService.getMedicinePriceById(i) * medicineItems.getIntValue(i);
        }
        medicineTable.setTotalPrice(sum);
        medicineTable.setMedicineTableState(0);
        int Count = medicineTableService.sendMedicineTable(medicineTable);
        if (Count == -1)
            return Response.error().message("上传出错，请检查处方单信息");
        else
            for(String i : medicineItems.keySet()){
                //把处方单的药品信息insert到medicineTableArray
                sum += medicineListService.getMedicinePriceById(i) * medicineItems.getIntValue(i);
                MedicineTableArray medicineTableArray = new MedicineTableArray();
                medicineTableArray.setMedicineTableArrayId(UUIDGenerator.makeUUID("mta"));
                medicineTableArray.setMedicineTableId(medicineTableId);
                medicineTableArray.setMedicineListId(i);
                medicineTableArray.setMedicineNum(medicineItems.getIntValue(i));
                int a = medicineTableArrayService.addMedicineTableArray(medicineTableArray);
                //修改库存
                int b = medicineListService.updateMedicineNum(i, medicineItems.getIntValue(i));
            }
        return Response.ok().message("上传成功");
    }
}
