package com.fightlandlord.sys_back.web.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pharmacist")
public class PharmacistRouterController {
    
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:21
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getAMedicineTableWithID")
    public String sendSubscribe(){
        return "sendSubscribe";
    }

    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:26
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getAMedicineTable")
    public String getAMedicineTable(){
        return "getAMedicineTable";
    }
    
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:28
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendMedicineTableState")
    public String sendMedicineTableState(){
        return "sendMedicineTableState";
    }
}
