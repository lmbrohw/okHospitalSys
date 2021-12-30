package com.fightlandlord.sys_back.web.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorRouterController {


    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAPatient")
    public String getAPatient(){
        return "getAPatient";
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
    public String getMedcineList(){
        return "getMedcineList";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:11
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getCheckList")
    public String getCheckList(){
        return "getCheckList";
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
        return "sendCheckTable";
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
