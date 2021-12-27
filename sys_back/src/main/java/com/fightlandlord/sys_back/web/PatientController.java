package com.fightlandlord.sys_back.web;

import com.fightlandlord.sys_back.model.Patient;

import com.fightlandlord.sys_back.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author: hudongyue
* @Description:
* @DateTime: 2021/12/26 15:39
*/

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/get")
    public Patient queryById(@RequestParam("id") String id){
        System.out.println("ID is " + id);
        Patient patient = patientService.queryById(id);
        System.out.println(patient.getName());
        System.out.println(patient.getGender());
        return patient;
    }
    @RequestMapping(path = "/test")
    public String test(){

        return "this is test method";
    }


}
