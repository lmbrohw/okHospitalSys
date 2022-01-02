package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.MedicineListService;
import com.fightlandlord.sys_back.service.MedicineTableArrayService;
import com.fightlandlord.sys_back.service.MedicineTableService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        MedicineTable medicineTable = medicineTableService.getAMedicineTableForDispenser();
        List<MedicineTableArray> medicineTableArrays = medicineTableArrayService.getMedicineTableByMedicineTableId(medicineTable.getMedicineTableId());

        if(medicineTable == null)
            return Response.ok().message("暂无待处理处方单！");

        // 拼接json
        Map<String,Object> jsonMap = new HashMap<String,Object>();

        // 拼接medicineTable
        jsonMap.put("medicineTableId", medicineTable.getMedicineTableId());
        jsonMap.put("patientId", medicineTable.getPatientId());
        jsonMap.put("doctorId", medicineTable.getDoctorId());
        jsonMap.put("pharmacistId", medicineTable.getPharmacistId());
        jsonMap.put("totalPrice", medicineTable.getTotalPrice());

        // 拼接medicineTableArray
        if(medicineTableArrays.size() != 0) {
            Map<String, Integer> tmpMap = new HashMap<String, Integer>();
            for(MedicineTableArray medicineTableArray : medicineTableArrays) {
                MedicineList medicineList = medicineListService.queryById(medicineTableArray.getMedicineListId());
                tmpMap.put(medicineList.getMedicineName(), medicineTableArray.getMedicineNum());
            }
            jsonMap.put("medicineTableArray", tmpMap);
        }

        return Response.ok().message("获取药单成功！").data(jsonMap);
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
    public Response sendMedicineTableState(@RequestParam("tableId") String medicineTableId,
                                           @RequestParam("dispenserId") String dispenserId,
                                           @RequestParam("state") int changeToState){
        // 查询是否存在该medicineTable
        if(medicineTableId.substring(0, 2).equals("mt")) {
            MedicineTable medicineTable = medicineTableService.queryById(medicineTableId);
            if(medicineTable.getMedicineTableState() != 2 && changeToState != 3) return Response.error().message("分发者没有改变此状态的权限");
            if(medicineTable == null) return Response.error().message("不存在该medicineTable！");

            medicineTable.setMedicineTableState(changeToState);
            medicineTable.setDispenserId(dispenserId);

            if(medicineTableService.modifyById(medicineTable) != 0)
                return Response.ok().message("修改medicineTable状态成功！");
            return Response.error().message("修改medicineTable状态失败！");
        }
        return Response.error().message("不存在该medicineTable！");
    }

}
