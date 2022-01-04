package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.dao.ChargerMapper;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.*;
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

    @Autowired
    DoctorService doctorService;

    @Autowired
    PharmacistService pharmacistService;

    @Autowired
    DispenserService dispenserService;

    @Autowired
    ChargerService chargerService;

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
            return Response.error().message("创建病人账户失败！");
        return Response.ok().message("创建病人账户成功！").data("patientId", patient.getPatientId());
    }

    @PostMapping(value = "/craeatDoctor")
    public Response creatDoctor(@RequestParam("doctorId") String doctorId,
                                @RequestParam("gender") int gender,
                                @RequestParam("age") int age,
                                @RequestParam("name") String name,
                                @RequestParam("password") String password){
        /**
         *
         *
         * @description:
         * @param doctorId
         * @param gender
         * @param age
         * @param name
         * @param password
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/4 12:42 PM
         */
        String docotorIdWithPrefix = "dt" + doctorId;
        Doctor doctor = new Doctor(docotorIdWithPrefix, gender, age, name, password);
        if(doctorService.insertDoctor(doctor) == 0)
            return Response.error().message("创建医生账户失败！");
        return Response.ok().message("创建医生账户成功！").data("doctorId", doctor.getDoctorId());
    }

    @PostMapping(value = "/creatPhamacist")
    public Response creatPharmacist(@RequestParam("pharmacistId") String pharmacistId,
                                    @RequestParam("gender") int gender,
                                    @RequestParam("age") int age,
                                    @RequestParam("name") String name,
                                    @RequestParam("password") String password){
        /**
         *
         *
         * @description:
         * @param pharmacistId
         * @param gender
         * @param age
         * @param name
         * @param password
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/4 12:50 PM
         */
          String pharmacistIdWithPrefix = "pm" + pharmacistId;
          Pharmacist pharmacist = new Pharmacist(pharmacistIdWithPrefix, gender, age, name, password);
          if (pharmacistService.insertPharmacist(pharmacist) == 0)
              return Response.error().message("创建药剂师账户失败！");
        return Response.ok().message("创建药剂师账户成功！").data("pharmacistId", pharmacist.getPharmacistId());

    }

    @PostMapping(value = "/creatdispenser")
    public Response creatDispenser(@RequestParam("dispenserId") String dispenserId,
                                   @RequestParam("gender") int gender,
                                   @RequestParam("age") int age,
                                   @RequestParam("name") String name,
                                   @RequestParam("password") String password){
        /**
         *
         *
         * @description:
         * @param dispenserId
         * @param gender
         * @param age
         * @param name
         * @param password
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/4 1:00 PM
         */
        String dispenserIDWithPrefix = "ds" + dispenserId;
        Dispenser dispenser = new Dispenser(dispenserIDWithPrefix, gender, age, name, password);

        if(dispenserService.insertDispenser(dispenser) == 0)
            return Response.error().message("创建配药师账户失败！");
        return Response.ok().message("创建配药师账户成功！").data("dispenserId", dispenser.getDispenserId());
    }

    @PostMapping(value = "/creatCharger")
    public Response creatCharger(@RequestParam("chargerId") String chargerId,
                                 @RequestParam("gender") int gender,
                                 @RequestParam("age") int age,
                                 @RequestParam("name") String name,
                                 @RequestParam("password") String password){
        /**
         *
         *
         * @description:
         * @param chargerId
         * @param gender
         * @param age
         * @param name
         * @param password
         * @return: com.fightlandlord.sys_back.util.Response
         * @author: Huwwwww
         * @time: 2022/1/4 1:17 PM
         */
        String chargerIdWithPrefix = "cg" + chargerId;
        Charger charger = new Charger(chargerIdWithPrefix,  gender, age, name, password);

        if(chargerService.insertcharger(charger) == 0)
            return Response.error().message("创建收费员账户失败！");
        return Response.ok().message("创建收费员账户成功！").data("chargerId", charger.getChargerId());
    }
}
