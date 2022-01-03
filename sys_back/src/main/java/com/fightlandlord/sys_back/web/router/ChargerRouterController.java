package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Patient;
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
        String prefix = tableId.substring(0, 2);
        ChargeTable chargeTable;
        if(prefix.equals("rg") || prefix.equals("ct") || prefix.equals("mt") ||
                prefix.equals("wm")) {// register checkTable medicineTable withdrawMedicineTable
            chargeTable = chargeTableService.queryById(tableId);
            if(chargeTable == null) return Response.error().message("不存在该账单！");
        } else return Response.error().message("不存在该账单！");

        return Response.ok().message("获取账单成功！").data("chargeTable", chargeTable);
    }

    /**
    * @Author: hudongyue
    * @Description: 收费者获取预约
    * @DateTime: 2021/12/26 21:36
    * @Params: patientId
    * @Return json格式预约信息
    */
    @GetMapping(value = "/getSubscribe")
    public Response getSubscribe(@RequestParam("patientId") String patientId){
        if((!patientId.substring(0, 2).equals("pt")) || patientService.queryById(patientId) == null) return Response.error().message("不存在该患者！");
        List<Subscribe> subscribeList = subscribeService.getSubscribeListByPatientId(patientId);
        if(subscribeList.size() == 0) return Response.error().message("该患者没有预约记录！");
        return Response.ok().message("获取该用户最近预约记录成功！").data("subscribe", subscribeList.get(0));
    }
    
    /**
    * @Author: hudongyue
    * @Description: 收费者更改收费单状态
    * @DateTime: 2021/12/26 21:37
    * @Params: tableId state
    * @Return 成功与否
    */
    @PostMapping(value = "/sendChargeTable")
    public Response sendChargeTable(@RequestParam("chargeItemId") String chargeItemId,
                                         @RequestParam("patientId") String patientId,
                                         @RequestParam("chargerId") String chargerId,
                                         @RequestParam("chargePrice") float chargePrice){
        // ************************************* id 判断 ***********************

        ChargeTable chargeTable = new ChargeTable(chargeItemId, patientId, chargerId, new Date(),chargePrice);

        if(chargeTableService.insertChargeTable(chargeTable) == 0)
            return Response.error().message("插入chargeTable失败！");

        return Response.ok().message("插入chargeTable成功！");
    }

    /**
     * @Author: hudongyue
     * @Description: 收费者更改收费单状态
     * @DateTime: 2021/12/26 21:37
     * @Params: tableId state
     * @Return 成功与否
     */
    @PostMapping(value = "/sendChargeTableState")
    public Response sendChargeTableState(@RequestParam("tableId") String chargeTableId,
                                         @RequestParam("state") int changeToState){

        return chargeTableService.modifyChargeTableState(chargeTableId, changeToState);
    }


    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/27 16:29
    * @Params:
    * @Return
    */
    @PostMapping(value = "/sendRegister")
    public Response sendRegister(@RequestParam("patientId") String patientId,
                                 @RequestParam("registerChoice") String registerChoice,
                                 @RequestParam("registerTime") String registerTime,
                                 @RequestParam("isSubscribe") int isSubscribe){
        /***** 时间处理 查询判断******/

        Register register = new Register(patientId, registerChoice, new Date(), isSubscribe);

        if(registerService.insertRegister(register) == 0)
            return Response.error().message("插入register失败！");
        return Response.ok().message("插入register成功！");
    }
}

