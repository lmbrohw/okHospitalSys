package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.MedicineList;
import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.model.MedicineTableArray;
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
@RequestMapping(path = "/pharmacist")
public class PharmacistRouterController {

    @Autowired
    MedicineTableService medicineTableService;

    @Autowired
    MedicineTableArrayService medicineTableArrayService;

    @Autowired
    MedicineListService medicineListService;
    
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:21
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getAMedicineTableWithID")
    public String sendSubscribe(){
        return "sendSubscribe";
    }

    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:26
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getAMedicineTable")
    public Response getAMedicineTable(){
        MedicineTable medicineTable = medicineTableService.getAMedicineTable(0);
        Map<String, Object> jsonMap = medicineTableService.getMedicineTableJSON(medicineTable);
        if(jsonMap == null || jsonMap.size() == 0) return Response.ok().message("暂无代配药处方单！");
        return Response.ok().message("获取处方单成功！").data(jsonMap);
    }
    
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:28
    * @Params: 
    * @Return 
    */
    @PostMapping(value = "/sendMedicineTableState")
    public Response sendMedicineTableState(@RequestParam("tableId") String medicineTableId,
                                           @RequestParam("pharmacistId") String pharmacistId,
                                           @RequestParam("state") int changeToState){
        return medicineTableService.modifyMedicineTableState(medicineTableId, pharmacistId, changeToState);
    }
}
