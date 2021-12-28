package com.fightlandlord.sys_back.web.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRouterController {
    
    
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:26
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getDoctorList")
    public String getDoctorList(){
        return "getDoctorList";
    }
}
