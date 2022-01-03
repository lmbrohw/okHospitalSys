package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DoctorMapper;
import com.fightlandlord.sys_back.dao.MedicineTableMapper;
import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.model.MedicineList;
import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.model.MedicineTableArray;
import com.fightlandlord.sys_back.service.MedicineListService;
import com.fightlandlord.sys_back.service.MedicineTableArrayService;
import com.fightlandlord.sys_back.service.MedicineTableService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MedicineTableServiceImpl implements MedicineTableService {

    @Autowired
    MedicineTableMapper medicineTableMapper;

    @Autowired
    MedicineTableArrayService medicineTableArrayService;

    @Autowired
    MedicineListService medicineListService;

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public MedicineTable queryById(String medicineTableId) {
        if(!medicineTableId.substring(0, 2).equals("mt")) return null;
        return medicineTableMapper.selectByPrimaryKey(medicineTableId);
    }

    @Override
    public Map<String, Object> getMedicineTableJSON(MedicineTable medicineTable) {
        if(medicineTable == null)
            return null;
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<MedicineTableArray> medicineTableArrays = medicineTableArrayService.getMedicineTableByMedicineTableId(medicineTable.getMedicineTableId());

        // 拼接medicineTable
        jsonMap.put("medicineTableId", medicineTable.getMedicineTableId());
        jsonMap.put("patientId", medicineTable.getPatientId());
        jsonMap.put("doctorId", medicineTable.getDoctorId());
        jsonMap.put("pharmacistId", medicineTable.getPharmacistId());
        jsonMap.put("totalPrice", medicineTable.getTotalPrice());

        // 拼接medicineTableArray
        if(medicineTableArrays.size() != 0) {
            List<Object> medicineTableArraysList = new LinkedList<>();
            for(MedicineTableArray medicineTableArray : medicineTableArrays) {
                Map<String, Object> medicineTableArrayMap = new HashMap<String, Object>();
                MedicineList medicineList = medicineListService.queryById(medicineTableArray.getMedicineListId());
                medicineTableArrayMap.put("medicineListId", medicineTableArray.getMedicineListId());
                medicineTableArrayMap.put("medicineName", medicineList.getMedicineName());
                medicineTableArrayMap.put("medicinePrice", medicineList.getMedicinePrice());
                medicineTableArrayMap.put("medicineDescription", medicineList.getMedicineDescription());
                medicineTableArrayMap.put("medicineNum", medicineTableArray.getMedicineNum());

                medicineTableArraysList.add(medicineTableArrayMap);
            }
            jsonMap.put("medicineTableArray", medicineTableArraysList);
        }

        return jsonMap;
    }

    @Override
    public MedicineTable getAMedicineTable(int role) {
        if(role == 1) // dispenser
            return medicineTableMapper.getAMedicineTableForDispenser();
        else if(role == 0) // pharmacist
            return medicineTableMapper.getAMedicineTableForPharmacist();
        return null;
    }

    @Override
    public Response modifyMedicineTableState(String medicineTableId, String roleId, int changeToState) {
        // 查询是否存在该medicineTable
        if(medicineTableId.substring(0, 2).equals("mt")) {
            MedicineTable medicineTable = medicineTableMapper.selectByPrimaryKey(medicineTableId);
            int role = -1;
            if(roleId.substring(0, 2).equals("pm"))
                role = 0;
            else if(roleId.substring(0, 2).equals("ds"))
                role = 1;

            if(role == 0) { // pharmacist
                if(medicineTable.getMedicineTableState() != 1 || changeToState != 2) return Response.ok().message("配药师没有改变此状态的权限");
            }else if(role == 1) { // dispenser
                if(medicineTable.getMedicineTableState() != 2 || changeToState != 3) return Response.ok().message("药剂师没有改变此状态的权限");
            }

            if(medicineTable == null) return Response.error().message("不存在该medicineTable！");

            medicineTable.setMedicineTableState(changeToState);

            if(role == 0) { // pharmacist
                medicineTable.setPharmacistId(roleId);
            }else if(role == 1) { // dispenser
                medicineTable.setDispenserId(roleId);
            }

            if(medicineTableMapper.updateByPrimaryKeySelective(medicineTable) != 0)
                return Response.ok().message("修改medicineTable状态成功！");
            return Response.error().message("修改medicineTable状态失败！");
        }
        return Response.error().message("不存在该medicineTable！");
    }

    @Override
    public int modifyById(MedicineTable medicineTable) {
        return medicineTableMapper.updateByPrimaryKeySelective(medicineTable);
    }

    @Override
    public int sendMedicineTable(MedicineTable medicineTable) {

        if (patientMapper.selectByPrimaryKey(medicineTable.getPatientId()) == null || doctorMapper.selectByPrimaryKey(medicineTable.getDoctorId()) == null)
            return -1;
        else
            return medicineTableMapper.insertSelective(medicineTable);
    }
}
