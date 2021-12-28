package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.service.ChargeTableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/charger")
public class ChargerRouterController {

    ChargeTableService chargeTableService;

    /**
    * @Author: hudongyue
    * @Description: 收费者获取收费单详细信息
    * @DateTime: 2021/12/26 21:20
    * @Params: tableID
    * @Return json格式的收费单数据
    */
    @GetMapping(value = "/getChargeTable")
<<<<<<< HEAD
    public String getChargeTable(@RequestParam("tableID") String tableID){
//        System.out.println("ID is " + tableID);
//        ChargeTable chargeTable = chargeTableService.queryById(tableID);
        return "getChargeTable";
=======
    public ChargeTable getChargeTable(@RequestParam("tableID") String tableID){
        System.out.println("ID is " + tableID);
        ChargeTable chargeTable = chargeTableService.queryById(tableID);
        return chargeTable;
>>>>>>> 75e2df208f874b09d79dec13919cfefb5607bc41
    }

    /**
    * @Author: hudongyue
    * @Description: 收费者获取预约
    * @DateTime: 2021/12/26 21:36
    * @Params: patientID
    * @Return json格式预约信息
    */
    @GetMapping(value = "/getSubscribe")
    public String getSubscribe(@RequestParam("patientID") String patientID){
        return "getSubscribe" + patientID;
    }
    
    /**
    * @Author: hudongyue
    * @Description: 收费者更改收费单状态
    * @DateTime: 2021/12/26 21:37
    * @Params: tableID state
    * @Return 成功与否
    */
    @PostMapping(value = "/sendChargeTableState")
    public String sendChargeTableState(){
        return "sendChargeTableState";
    }

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/27 16:29
    * @Params:
    * @Return
    */
    @PostMapping(value = "/sendRegister")
    public String sendRegister(){
        return "sendRegister";
    }
}

