package com.fightlandlord.sys_back.web.router;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.model.Subscribe;
import com.fightlandlord.sys_back.service.DepartmentService;
import com.fightlandlord.sys_back.service.DoctorService;
import com.fightlandlord.sys_back.service.PatientService;
import com.fightlandlord.sys_back.service.SubscribeService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/patient")
public class PatientRouterController {

    @Autowired
    SubscribeService subscribeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:16
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendSubscribe")
    public Response sendSubscribe(@RequestParam("patientId") String patientId,
                                  @RequestParam("subscribeChoice") String subscribeChoice,
                                  @RequestParam("subscribeTime") String subscribeTime,
                                  @RequestParam("token") String token) throws ParseException {
        // 判断subscribe类型
        // 判断subscribeChoice在数据库中是否存在
        // dp为department表示普通预约，dt为doctor表示专家预约
        if(subscribeChoice.length() < 2) return Response.error().message("请选择专家或者科室！");
        String subscribeChoiceType = subscribeChoice.substring(0, 2);

        System.out.println("patientId:" + patientId);
        System.out.println("department1:" + subscribeChoice);

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
        System.out.println("department2:" + subscribeChoice);
        /**
         * 此处date还需处理（已处理），同时限制预约人数
        */

//        Date date = new Date(subscribeTime);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = ft.parse(subscribeTime);

        Subscribe newSubscribe = new Subscribe(patientId, subscribeChoice, date);
//        System.out.println(subscribeService.querySubscribeNumBydoctorId(newSubscribe.getSubscribeChoice(), newSubscribe.getSubscribeTime()));
        if(newSubscribe.getSubscribeChoice().substring(0,2).equals("dt") && subscribeService.querySubscribeNumBydoctorId(newSubscribe.getSubscribeChoice(), newSubscribe.getSubscribeTime()) >= 10){
            return Response.error().message("当前时间段预约人数过多，请重新选择预约时间或医生");
        }
        if(newSubscribe.getSubscribeChoice().substring(0,2).equals("dp") && subscribeService.querySubscribeNumBydoctorId(newSubscribe.getSubscribeChoice(), newSubscribe.getSubscribeTime()) >=30){
            return Response.error().message("当前时间段预约人数过多，请重新选择预约时间或医生");
        }
        if (subscribeService.insertSubscribe(newSubscribe) != 0)
            return Response.ok().message("预约成功").data("subscribeId", newSubscribe.getSubscribeId());
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

    @GetMapping(value = "/getSubscribeList")
    public Response sendSubscribeState(@RequestParam("patientId") String pateintId){
        // 查询是否存在该subscribe
        if(patientService.queryById(pateintId) == null) return Response.error().message("不存在该patient！");
        List<Subscribe> subscribeList = subscribeService.getSubscribeListByPatientId(pateintId);
        if(subscribeList.size() == 0) return Response.ok().message("没有预约记录！");
        return Response.ok().message("获取预约记录成功").data("subscribeList", subscribeList);
    }
}
