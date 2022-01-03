package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.MedicineListService;
import com.fightlandlord.sys_back.service.MedicineTableArrayService;
import com.fightlandlord.sys_back.service.MedicineTableService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/dispenser")
public class DispenserRouterController {

    @Autowired
    MedicineTableService medicineTableService;

    @Autowired
    MedicineTableArrayService medicineTableArrayService;

    @Autowired
    MedicineListService medicineListService;

    /**
    * @Author: hudongyue
    * @Description:
    * @DateTime: 2021/12/28 15:56
    * @Params:
    * @Return
    */
    @GetMapping(value = "/getAMedicineTableWithID")
    public String getAMedicineTableWithId(@RequestParam("tableId") String tableId){
//        System.out.println("Id is " + tableId);
//        MedicineTable medicineTable = medicineTableService.queryById(tableId);
        return "getAMedicineTableWithId";
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/27 16:29
     * @Params:
     * @Return
     */
    @GetMapping(value = "/getAMedicineTable")
    public Response getAMedicineTable(){
        Map<String,Object> jsonMap = medicineTableService.getAMedicineTable(1);
        if(jsonMap.size() == 0) return Response.ok().message("暂无代审核处方单！");
        return Response.ok().message("获取处方单成功！").data(jsonMap);
    }

    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:01
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendWithdrawMedicineTable")
    public Response sendWithdrawMedicineTable(){
        return null;
    }

    /**
     * @Author: hudongyue
     * @Description:
     * @DateTime: 2021/12/28 16:01
     * @Params:
     * @Return
     */
    @PostMapping(value = "/sendMedicineTableState")
    public Response sendMedicineTableState(@RequestParam("tableId") String medicineTableId,
                                           @RequestParam("dispenserId") String dispenserId,
                                           @RequestParam("state") int changeToState){

        return medicineTableService.modifyMedicineTableState(medicineTableId, dispenserId, changeToState);
    }

}
