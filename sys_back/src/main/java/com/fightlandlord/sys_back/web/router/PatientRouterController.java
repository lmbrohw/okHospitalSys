package com.fightlandlord.sys_back.web.router;

<<<<<<< HEAD
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
=======
public class PatientRouterController {
>>>>>>> 75e2df208f874b09d79dec13919cfefb5607bc41
}
