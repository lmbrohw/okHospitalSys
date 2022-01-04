package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.service.PatientService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/createAccount")
public class CreateAccountRouterController {

    @Autowired
    PatientService patientService;

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:28
     * @Params:
     * @Return
     */
    @PostMapping(value = "/createPatient")
    public Response createPatient(@RequestParam("patientId") String patientId,
                                  @RequestParam("gender") int gender,
                                  @RequestParam("age") int age,
                                  @RequestParam("name") String name,
                                  @RequestParam("password") String password){
        String patientIdWithPrefix = "pt" + patientId;
        Patient patient = new Patient(patientIdWithPrefix, gender, age, name, password);

        if(patientService.insertPatient(patient) == 0)
            return Response.error().message("创建病人失败！");
        return Response.ok().message("创建病人成功！").data("patientId", patient.getPatientId());
    }
}
