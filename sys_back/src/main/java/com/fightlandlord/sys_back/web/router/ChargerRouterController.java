package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Register;
import com.fightlandlord.sys_back.model.Subscribe;
import com.fightlandlord.sys_back.service.ChargeTableService;
import com.fightlandlord.sys_back.service.PatientService;
import com.fightlandlord.sys_back.service.RegisterService;
import com.fightlandlord.sys_back.service.SubscribeService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/charger")
public class ChargerRouterController {

    @Autowired
    ChargeTableService chargeTableService;

    @Autowired
    SubscribeService subscribeService;

    @Autowired
    PatientService patientService;

    @Autowired
    RegisterService registerService;

    /**
    * @Author: hudongyue
    * @Description: 收费者获取收费单详细信息
    * @DateTime: 2021/12/26 21:20
    * @Params: tableId
    * @Return json格式的收费单数据
    */
    @GetMapping(value = "/getChargeTable")
    public Response getChargeTable(@RequestParam("tableId") String tableId){
        if(tableId.length() < 2) return Response.error().message("不存在该账单！");
        String prefix = tableId.substring(0, 2);
        ChargeTable chargeTable;
        if(prefix.equals("rg") || prefix.equals("ct") || prefix.equals("mt") ||
                prefix.equals("wm")) {// register checkTable medicineTable withdrawMedicineTable
            chargeTable = chargeTableService.queryById(tableId);
            if(chargeTable == null) return Response.error().message("不存在该账单！");
        } else return Response.error().message("不存在该账单！");

        return Response.ok().message("获取账单成功！").data("chargeTable", chargeTable);
    }

    @GetMapping(value = "/getSubscribe")
    public Response getSubscribe(@RequestParam("patientId") String patientId){
        if(patientService.queryById(patientId) == null) return Response.error().message("不存在该患者！");
        List<Subscribe> subscribeList = subscribeService.getSubscribeListByPatientId(patientId);
        if(subscribeList.size() == 0) return Response.error().message("该患者没有预约记录！");
        return Response.ok().message("获取该用户最近预约记录成功！").data("subscribe", subscribeList.get(0));
    }

    @PostMapping(value = "/sendChargeTableState")
    public Response sendChargeTableState(@RequestParam("tableId") String chargeTableId,
                                         @RequestParam("chargerId") String chargerId){

        return chargeTableService.modifyChargeTableState(chargeTableId, chargerId, 1);
    }

    @PostMapping(value = "/sendRegister")
    public Response sendRegister(@RequestParam("patientId") String patientId,
                                 @RequestParam("registerChoice") String registerChoice,
                                 @RequestParam("registerTime") String registerTime,
                                 @RequestParam("isSubscribe") int isSubscribe){
        /***** 时间处理 查询判断******/
        if(patientService.queryById(patientId) == null) return Response.error().message("不存在该病人！");

        Register register = new Register(patientId, registerChoice, new Date(), isSubscribe);

        // chargeItemId, patientId, chargerId, chargeCreateTime, chargePrice
        ChargeTable chargeTable = new ChargeTable();
        chargeTable.setChargeTableId(register.getRegisterId());
        chargeTable.setPatientId(patientId);
        chargeTable.setChargeCreateTime(new Date());
        if(register.getRegisterChoice().substring(0, 2).equals("dt"))
            chargeTable.setChargePrice(50); // 专家挂号50
        else chargeTable.setChargePrice(10); // 普通挂号10
        chargeTable.setChargeState(0);

        /***** subscribe state ******/

        if(registerService.insertRegister(register) == 0 || chargeTableService.insertChargeTable(chargeTable) == 0)
            return Response.error().message("插入register失败！");
        return Response.ok().message("插入register成功！");
    }
}

