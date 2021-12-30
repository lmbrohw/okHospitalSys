package com.fightlandlord.sys_back.web.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/patient")
public class PatientRouterController {


    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:16
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendSubscribe")
    public String sendSubscribe(){
        return "sendSubscribe";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:16
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendSubscribeState")
    public String sendSubscribeState(){
        return "sendSubscribeState";
    }
}
