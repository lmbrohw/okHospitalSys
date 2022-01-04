package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.*;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/dispenser")
public class DispenserRouterController {

    @Autowired
    MedicineTableService medicineTableService;

    @Autowired
    MedicineListService medicineListService;

    @Autowired
    WithdrawMedicineTableService withdrawMedicineTableService;

    @Autowired
    WithdrawMedicineTableArrayService withdrawMedicineTableArrayService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DispenserService dispenserService;

    @Autowired
    ChargeTableService chargeTableService;

    @Autowired
    RegisterService registerService;



    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 15:56
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getAMedicineTableWithID")
    public Response getAMedicineTableWithId(@RequestParam("tableId") String medicineTableId){
        MedicineTable medicineTable = medicineTableService.queryById(medicineTableId);
        Map<String, Object> jsonMap = medicineTableService.getMedicineTableJSON(medicineTable);
        if(jsonMap == null || jsonMap.size() == 0) return Response.error().message("不存在该medicineTable！");
        return Response.ok().message("成功获取medicineTable!").data(jsonMap);
    }

    @GetMapping(value = "/getAMedicineTable")
    public Response getAMedicineTable(){
        MedicineTable medicineTable = medicineTableService.getAMedicineTable(1);
        Map<String, Object> jsonMap = medicineTableService.getMedicineTableJSON(medicineTable);
        if(jsonMap == null || jsonMap.size() == 0) return Response.ok().message("暂无代审核处方单！");
        return Response.ok().message("获取处方单成功！").data(jsonMap);
    }

    @PostMapping(value = "/sendWithdrawMedicineTable")
    public Response sendWithdrawMedicineTable(@RequestBody String json){
        JSONObject jsonObject= JSON.parseObject(json);
        String medicineTableId=jsonObject.getString("medicineTableId");
        String patientId=jsonObject.getString("patientId");
        String doctorId=jsonObject.getString("doctorId");
        String dispenserId=jsonObject.getString("dispenserId");
        JSONObject withdrawMedicineTableMap=jsonObject.getJSONObject("withdrawMedicineTableMap");

        // 计算总价
        float totalPrice = 0;
        for(String medicineListId : withdrawMedicineTableMap.keySet()){
            MedicineList medicineList = medicineListService.queryById(medicineListId);
            if(medicineList == null) return Response.error().message("退药单中的药库中不存在！");
            totalPrice += medicineList.getMedicinePrice() * withdrawMedicineTableMap.getIntValue(medicineListId);
        }

        if(medicineTableService.queryById(medicineTableId) == null) return Response.error().message("该medicineTable不存在！");
        if(patientService.queryById(patientId) == null) return Response.error().message("该patient不存在！");
        if(doctorService.queryById(doctorId) == null) return Response.error().message("该doctor不存在！");
        if(dispenserService.queryById(dispenserId) == null) return Response.error().message("该dispenser不存在！");

        WithdrawMedicineTable withdrawMedicineTable = new WithdrawMedicineTable(medicineTableId, patientId, doctorId, dispenserId, totalPrice);

        // 将退药单存入数据库
        if(withdrawMedicineTableService.sendWithdrawMedicineTable(withdrawMedicineTable) == 0)
            return Response.error().message("退药单存入数据库出错！");

        // insert withdrawMedicineTableArray
        for(String medicineListId : withdrawMedicineTableMap.keySet()){
            WithdrawMedicineTableArray withdrawMedicineTableArray = new WithdrawMedicineTableArray(withdrawMedicineTable.getWithdrawMedicineTableId(),
                    medicineListId, withdrawMedicineTableMap.getIntValue(medicineListId));
            if(withdrawMedicineTableArrayService.sendWithdrawMedicineTableArray(withdrawMedicineTableArray) == 0) {
                return Response.error().message("退药单存入数据库出错！");
            }
        }
        // chargeItemId, patientId, chargerId, chargeCreateTime, chargePrice
        /** 生成对应账单 **/
        ChargeTable chargeTable = new ChargeTable();
        chargeTable.setChargeTableId(withdrawMedicineTable.getWithdrawMedicineTableId());
        chargeTable.setPatientId(patientId);
        chargeTable.setChargeCreateTime(new Date());
        chargeTable.setChargePrice(totalPrice);
        chargeTable.setChargeState(0);

        /** change medicineTable state **/
        //在 Register 中填写 withdrawMedicineTableId
        Register register = registerService.queryByMedicneId(withdrawMedicineTable.getMedicineTableId());
        register.setWithdrawMedicineTableId(withdrawMedicineTable.getWithdrawMedicineTableId());
        if(registerService.addTreatInfo(register) == 0)
            return Response.error().message("向register表添加withdrawMedicineTableId出错！");

        if(chargeTableService.insertChargeTable(chargeTable) == 0)
            return Response.error().message("退药单对应账单存入数据库出错！");

        return Response.ok().message("退药单生成成功！").data("withdrawMedicineTableId", withdrawMedicineTable.getWithdrawMedicineTableId());
    }

    @PostMapping(value = "/sendMedicineTableState")
    public Response sendMedicineTableState(@RequestParam("tableId") String medicineTableId,
                                           @RequestParam("dispenserId") String dispenserId,
                                           @RequestParam("state") int changeToState){

        return medicineTableService.modifyMedicineTableState(medicineTableId, dispenserId, changeToState);
    }

}
