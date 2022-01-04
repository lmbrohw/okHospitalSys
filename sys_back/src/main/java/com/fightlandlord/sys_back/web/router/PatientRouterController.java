package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.Subscribe;
import com.fightlandlord.sys_back.service.DepartmentService;
import com.fightlandlord.sys_back.service.DoctorService;
import com.fightlandlord.sys_back.service.SubscribeService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
@RequestMapping(path = "/patient")
public class PatientRouterController {

    @Autowired
    SubscribeService subscribeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DoctorService doctorService;

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:16
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendSubscribe")
    public Response sendSubscribe(@RequestBody String json){
        JSONObject jsonObject= JSON.parseObject(json);
        String patientId=jsonObject.getString("patientId");
        String subscribeChoice=jsonObject.getString("subscribeChoice");
        String subscribeTime=jsonObject.getString("subscribeTime");

        // 判断subscribe类型
        // 判断subscribeChoice在数据库中是否存在
        // dp为department表示普通预约，dt为doctor表示专家预约
        if(subscribeChoice.length() < 2) return Response.error().message("请选择专家或者科室！");
        String subscribeChoiceType = subscribeChoice.substring(0, 2);
        if(subscribeChoiceType.equals("dp")) {
            if(departmentService.queryById(subscribeChoice) == null) {
                return Response.error().message("不存在该科室！");
            }
        } else if(subscribeChoiceType.equals("dt")) {
            if(doctorService.queryById(subscribeChoice) == null) {
                return Response.error().message("不存在该专家！");
            }
        } else {
            return Response.error().message("请选择专家或者科室！");
        }

        /**
         * 此处date还需处理
        */

        Subscribe newSubscribe = new Subscribe(patientId, subscribeChoice, new Date());

        if (subscribeService.insertSubscribe(newSubscribe) != 0)
            return Response.ok().message("预约成功");
        return Response.error().message("插入数据库失败!");
    }

    @PostMapping(value = "/sendSubscribeState")
    public Response sendSubscribeState(@RequestParam("subscribeId") String subscribeId,
                                       @RequestParam("changeToState") int changeToState){

        // 查询是否存在该subscribe
        Subscribe subscribe = subscribeService.queryById(subscribeId);
        if(changeToState < 0 || changeToState > 2) return Response.error().message("subscribe不存在该状态");
        if(subscribe == null) return Response.error().message("不存在该subscribe！");
        subscribe.setSubscribeState(changeToState);
        if(subscribeService.modifyById(subscribe) != 0)
           return Response.ok().message("修改subscribe状态成功！");
        return Response.error().message("修改subscribe状态失败！");

    }
}
