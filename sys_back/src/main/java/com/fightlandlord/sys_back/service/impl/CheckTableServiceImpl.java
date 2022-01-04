package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.CheckTableArrayMapper;
import com.fightlandlord.sys_back.dao.CheckTableMapper;
import com.fightlandlord.sys_back.dao.DoctorMapper;
import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.CheckListService;
import com.fightlandlord.sys_back.service.CheckTableArrayService;
import com.fightlandlord.sys_back.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CheckTableServiceImpl implements CheckTableService {
    @Autowired
    CheckTableMapper checkTableMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    CheckTableArrayMapper checkTableArrayMapper;
    @Autowired
    CheckTableArrayService checkTableArrayService;
    @Autowired
    CheckListService checkListService;

    @Override
    public int sendCheckTable(CheckTable checkTable) {

        if (patientMapper.selectByPrimaryKey(checkTable.getPatientId()) == null || doctorMapper.selectByPrimaryKey(checkTable.getDoctorId()) == null)
            return -1;
        else
            return checkTableMapper.insertSelective(checkTable);
    }

    @Override
    public Map<String, Object> getCheckTableJSON(CheckTable checkTable) {
        if (checkTable == null)
            return null;
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        List<CheckTableArray> checkTableArrays = checkTableArrayService.getCheckTableByCheckTableId(checkTable.getCheckTableId());

        //拼接checkTable
        jsonMap.put("checkTableId", checkTable.getCheckTableId());
        jsonMap.put("patient", checkTable.getPatientId());
        jsonMap.put("doctorId", checkTable.getDoctorId());
        jsonMap.put("totalPrice", checkTable.getTotalPrice());

        //拼接checkTableArray
        if (checkTableArrays.size() != 0) {
            List<Object> checkTableArraysList = new LinkedList<>();
            for (CheckTableArray checkTableArray : checkTableArrays) {
                Map<String, Object> checkTableArrayMap = new HashMap<>();
                CheckList checkList = checkListService.queryById(checkTableArray.getCheckListId());
                checkTableArrayMap.put("checkListid", checkTableArray.getCheckListId());
                checkTableArrayMap.put("checkName", checkList.getCheckName());
                checkTableArrayMap.put("checkPrice", checkList.getCheckPrice());
                checkTableArrayMap.put("checkDescription", checkList.getCheckDescription());

                checkTableArraysList.add(checkTableArrayMap);
            }
            jsonMap.put("checkTablearray", checkTableArraysList);
        }
        return jsonMap;
    }

    @Override
    public CheckTable queryById(String checkTableId) {
        if(checkTableId.length() < 2 || !checkTableId.substring(0, 2).equals("ct")) return null;
        return checkTableMapper.selectByPrimaryKey(checkTableId);
    }

    @Override
    public int modifyCheckTableState(String checkTableId, int state) {
        CheckTable checkTable = queryById(checkTableId);
        if(checkTable == null) return 0;
        checkTable.setCheckTableState(state);
        return checkTableMapper.updateByPrimaryKeySelective(checkTable);
    }

}
