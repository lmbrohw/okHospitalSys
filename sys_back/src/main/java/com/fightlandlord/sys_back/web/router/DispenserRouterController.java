package com.fightlandlord.sys_back.web.router;

<<<<<<< HEAD
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.service.MedicineTableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/dispenser")
public class DispenserRouterController {

    MedicineTableService medicineTableService;

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 15:56
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getAMedicineTableWithID")
    public String getAMedicineTableWithID(@RequestParam("tableID") String tableID){
//        System.out.println("ID is " + tableID);
//        MedicineTable medicineTable = medicineTableService.queryById(tableID);
        return "getAMedicineTableWithID";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/27 16:29
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAMedicineTable")
    public String getAMedicineTable(){
        return "getAMedicineTable";
    }

    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:01
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendWithdrawMedicineTable")
    public String sendWithdrawMedicineTable(){
        return "sendWithdrawMedicineTable";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendMedicineTableState")
    public String sendMedicineTableState(){
        return "sendMedicineTableState";
    }
    
=======
public class DispenserRouterController {
>>>>>>> 75e2df208f874b09d79dec13919cfefb5607bc41
}
