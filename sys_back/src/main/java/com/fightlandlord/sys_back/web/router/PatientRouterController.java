package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.Subscribe;
import com.fightlandlord.sys_back.service.SubscribeService;
import com.fightlandlord.sys_back.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping(path = "/patient")
public class PatientRouterController {

    @Autowired
    SubscribeService subscribeService;

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:16
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendSubscribe")
    public String sendSubscribe(@RequestBody String json){
        JSONObject jsonObject= JSON.parseObject(json);
        String patientID=jsonObject.getString("patientID");
        String subscribeChoice=jsonObject.getString("subscribeChoice");
        String subscribeTime=jsonObject.getString("subscribeTime");

        System.out.println("pateintID:" + patientID);
        System.out.println("subscribeChoice:" + subscribeChoice);
        System.out.println("subscribeTime:" + subscribeTime);

        Subscribe newSubscribe = new Subscribe();
        newSubscribe.setSubscribeId(UUIDGenerator.makeUUID("sb"));
        newSubscribe.setPatientId(patientID);
        newSubscribe.setSubscribeChoice(subscribeChoice);
        newSubscribe.setSubscribeTime(new Date());
        newSubscribe.setSubscribeState(0);

        subscribeService.insertSubscribe(newSubscribe);

//        if (subscribeService.insertSubscribe(newSubscribe) != 0)
//            System.out.println("插入数据库成功");
//        else System.out.println("插入数据库失败");

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
