package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.CheckList;
import com.fightlandlord.sys_back.model.MedicineList;
import com.fightlandlord.sys_back.model.Register;
import com.fightlandlord.sys_back.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorRouterController {


    @Autowired
    DoctorService doctorService;
    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAPatient")
    public Register getAPatient(String doctorId){

        return doctorService.getAPatient(doctorId);
    }

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 16:11
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getPatientRecord")
    public String getPatientRecord(){
        return "getPatientRecord";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getMedcineList")
    public List<MedicineList> getMedcineList(){

        return doctorService.getMedicineList();
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getCheckList")
    public List<CheckList> getCheckList(){

        return doctorService.getCheckList();
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendDossierTable")
    public String sendDossierTable(){

        return "sendDossierTable";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendCheckTable")
    public String sendCheckTable(){

        return "send";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendMedicineTable")
    public String sendMedicineTable(){
        return "sendMedicineTable";
    }
}
