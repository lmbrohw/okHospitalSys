package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.*;
import com.fightlandlord.sys_back.util.Response;
import com.fightlandlord.sys_back.util.UUIDGenerator;
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
    @Autowired
    ChargeTableService chargeTableService;
    @GetMapping(value = "/getAPatient")
    public Response getAPatient(String doctorId){
        /**
         *
         *
         * @description:
         * @param doctorId
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:31 PM
         */

        Register register = patientService.getAPatient(doctorId);
        if (register == null)
            return Response.error().message("没有正在等待的病人");
        else
            return Response.ok().message("获取成功").data("patientInfo", register);
    }

    @GetMapping(value = "/getPatientRecord")
    public Response getPatientRecord(String patientId){
        /**
         *
         *
         * @description:
         * @param patientId
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:31 PM
         */

        List<Register> registeRecords = registerService.getRegisterByPatientId(patientId);
        List<Map<String, Object>> allRecords = new LinkedList<>();

        for (Register registeRecord :registeRecords){
            Map<String,Object> oneTreatmentInfo = new HashMap<>();
            Date time = registeRecord.getRegisterTime();
            String doctorId = registeRecord.getRegisterChoice();

            if (registeRecord.getDossierTableId() != null){
                DossierTable dossierTableRecord = dossierTableService.queryById(registeRecord.getDossierTableId());
                oneTreatmentInfo.put("dossierTable", dossierTableRecord);
            }
            if (registeRecord.getMedicineTableId() != null){
                Map<String, Object> medicineTableRecord = medicineTableService.getMedicineTableJSON(medicineTableService.queryById(registeRecord.getMedicineTableId()));
                oneTreatmentInfo.put("medicineTable", medicineTableRecord);
            }
            if (registeRecord.getCheckTableId() != null){
                Map<String, Object> checkTableRecord = checkTableService.getCheckTableJSON((checkTableService.queryById(registeRecord.getCheckTableId())));
                oneTreatmentInfo.put("checkTable", checkTableRecord);
            }
            oneTreatmentInfo.put("time", time);
            oneTreatmentInfo.put("doctorId", doctorId);
            allRecords.add(oneTreatmentInfo);
        }

        return Response.ok().message("查询成功").data("treatmentInfoList", allRecords);
    }

    @GetMapping(value = "/getMedicineList")
    public Response getMedicineList(){
        /**
         *
         *
         * @description:
         * @param
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:32 PM
         */

        return Response.ok().message("查询成功").data("medicineListInfo", medicineListService.getMedicineList());
    }

    @GetMapping(value = "/getCheckList")
    public Response getCheckList(){
        /**
         *
         *
         * @description:
         * @param
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:32 PM
         */

        return Response.ok().message("查询成功").data("checkListInfo",checkListService.getCheckList());
    }

    @PostMapping(value = "/sendDossierTable")
    public Response sendDossierTable(String registerId, String doctorId, String patientId, String description){
        /**
         *
         *
         * @description:
         * @param registerId
         * @param doctorId
         * @param patientId
         * @param description
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:32 PM
         */

        DossierTable dossierTable = new DossierTable();
        dossierTable.setDossierTableId(UUIDGenerator.makeUUID("dt"));
        dossierTable.setDoctorId(doctorId);
        dossierTable.setPatientId(patientId);
        dossierTable.setDescription(description);

        int Count = dossierTableService.sendDossierTable(dossierTable);
        if(Count == -1)
            return Response.error().message("上传出错，请检查病历基本信息");
        else{
            //在 Register 中填写 dossierTableId
            Register register = registerService.queryById(registerId);
            register.setCheckTableId(dossierTable.getDossierTableId());
            int a = registerService.addTreatInfo(register);
            return Response.ok().message("病历上传成功").data("dossierTableId", dossierTable.getDossierTableId());
        }
    }

    @PostMapping(value = "/sendCheckTable")
    public Response sendCheckTable(@RequestBody String params){
        /**
         *
         *
         * @description:
         * @param params
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:33 PM
         */

        JSONObject jsonObject = JSON.parseObject(params);
        JSONObject checkItems = jsonObject.getJSONObject("checkTable");
        CheckTable checkTable = new CheckTable();
        String checkTableId = UUIDGenerator.makeUUID("ct");
        checkTable.setCheckTableId(checkTableId);
        checkTable.setPatientId(jsonObject.getString("patientId"));
        checkTable.setDoctorId(jsonObject.getString("doctorId"));
        /** 计算 totalprice **/
        float sum= 0f;
        for(String i : checkItems.keySet()){
            float price = checkListService.getCheckItemPriceById(i);
            if (price == -1) return Response.error().message("上传出错，请检查申请项目信息是否正确");
            sum += price * checkItems.getIntValue(i);
        }
        checkTable.setTotalPrice(sum);
        //添加 ChagrgeTable 记录
        ChargeTable chargeTable = new ChargeTable();
        chargeTable.setChargeTableId(checkTableId);
        chargeTable.setPatientId(jsonObject.getString("patientId"));
        chargeTable.setChargePrice(sum);
        chargeTable.setChargeState(0);
        chargeTable.setChargeCreateTime(new Date());
        //在 Register 中填写 checkTableId
        Register register = registerService.queryById(jsonObject.getString("registerId"));
        register.setCheckTableId(checkTableId);

        int Count = checkTableService.sendCheckTable(checkTable);
        if (Count == -1)
            return Response.error().message("上传出错，请检查申请单基本信息");
        else{
            //将 medicineTableId 字段传入 register
            int d = registerService.addTreatInfo(register);
            //insert 到 chargeTable
            int c = chargeTableService.insertChargeTable(chargeTable);
            //把检申请项目信息insert到checkTableArray
            for(String i : checkItems.keySet()){
                CheckTableArray checkTableArray = new CheckTableArray();
                checkTableArray.setCheckTableArrayId(UUIDGenerator.makeUUID("cta"));
                checkTableArray.setCheckTableId(checkTableId);
                checkTableArray.setCheckListId(i);
                int a = checkTableArrayService.addCheckTableArray(checkTableArray);
            }
        }

        return Response.ok().message("上传成功").data("checkTableId", checkTableId);
    }

    @PostMapping(value = "/sendMedicineTable")
    public Response sendMedicineTable(@RequestBody String params){
        /**
         *
         *
         * @description:
         * @param params
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/2 1:33 PM
         */

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

            if (medicineItems.getIntValue(i) > medicineListService.queryInventoryById(i)) return Response.error().message("上传出错，请检查处方单药品信息");
            float price = medicineListService.getMedicinePriceById(i);
            if (price == -1) return Response.error().message("上传出错，请检查处方单药品信息");
            sum += price * medicineItems.getIntValue(i);
        }
        medicineTable.setTotalPrice(sum);
        medicineTable.setMedicineTableState(0);
        //添加 ChagrgeTable 记录
        ChargeTable chargeTable = new ChargeTable();
        chargeTable.setChargeTableId(medicineTableId);
        chargeTable.setChargePrice(sum);
        chargeTable.setPatientId(jsonObject.getString("patientId"));
        chargeTable.setChargeState(0);
        chargeTable.setChargeCreateTime(new Date());
        //在 Register 中填写 medicineTableId
        Register register = registerService.queryById(jsonObject.getString("registerId"));
        register.setMedicineTableId(medicineTableId);

        int Count = medicineTableService.sendMedicineTable(medicineTable);
        if (Count == -1)
            return Response.error().message("上传出错，请检查处方单基本信息");
        else{
            //将medicineTableId字段传入register
            int d = registerService.addTreatInfo(register);
            //insert到chargeTable
            int c = chargeTableService.insertChargeTable(chargeTable);
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
        }
        return Response.ok().message("上传成功").data("medicineTableId", medicineTableId);
    }

    @PostMapping(value = "/sendRegisterState")
    public Response sendRegisterState(@RequestParam("tableId") String registerId){
        /**
         *
         *
         * @description:
         * @param registerId
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/3 20:34 PM
         */

        if(registerService.modifyRegisterState(registerId, 3) == 0)
            return Response.error().message("改变register状态失败！");
        return Response.ok().message("改变register状态成功！");
    }
}
