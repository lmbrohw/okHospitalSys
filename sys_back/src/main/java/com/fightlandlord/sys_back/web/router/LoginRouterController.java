package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.*;
import com.fightlandlord.sys_back.util.JwtToken;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController

public class LoginRouterController {

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

    @GetMapping(path = "/login")
    public Response login(@RequestParam("userId") String userId,
                          @RequestParam("password") String password){
        String prefix = userId.substring(0, 2);
        if(prefix.equals("pt")) { // patient
            Patient patient = patientService.queryById(userId);
            if(patient == null || !Objects.equals(patient.getPassword(), password))
                return Response.error().message("登录失败，账户或者密码错误！");
            return Response.ok().message("登录成功！").data("token", JwtToken.createToken(userId));
        } else if(prefix.equals("dt")) {// doctor
            Doctor doctor = doctorService.queryById(userId);
            if(doctor == null || !Objects.equals(doctor.getPassword(), password))
                return Response.error().message("登录失败，账户或者密码错误！");
            return Response.ok().message("登录成功！").data("token", JwtToken.createToken(userId));
        } else if(prefix.equals("pm")) {// pharmacist
            Pharmacist pharmacist = pharmacistService.queryById(userId);
            if(pharmacist == null || !Objects.equals(pharmacist.getPassword(), password))
                return Response.error().message("登录失败，账户或者密码错误！");
            return Response.ok().message("登录成功！").data("token", JwtToken.createToken(userId));
        } else if(prefix.equals("ds")) {// dispenser
            Dispenser dispenser = dispenserService.queryById(userId);
            if(dispenser == null || !Objects.equals(dispenser.getPassword(), password))
                return Response.error().message("登录失败，账户或者密码错误！");
            return Response.ok().message("登录成功！").data("token", JwtToken.createToken(userId));
        } else if(prefix.equals("cg")) {// charger
            Charger charger = chargerService.queryById(userId);
            if(charger == null || !Objects.equals(charger.getPassword(), password))
                return Response.error().message("登录失败，账户或者密码错误！");
            return Response.ok().message("登录成功！").data("token", JwtToken.createToken(userId));
        }
        return Response.error().message("登录失败，账户或者密码错误！");
    }

    public boolean auth(String userId) {
        String prefix = userId.substring(0, 2);
        if(prefix.equals("pt")) { // patient
            Patient patient = patientService.queryById(userId);
            if(patient == null)
                return false;
            return true;
        } else if(prefix.equals("dt")) {// doctor

        } else if(prefix.equals("pm")) {// pharmacist
        } else if(prefix.equals("ds")) {// dispenser
        } else if(prefix.equals("cg")) {// charger
        }
        return false;
    }
}
