package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.CheckTableMapper;
import com.fightlandlord.sys_back.dao.DoctorMapper;
import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.model.CheckTable;
import com.fightlandlord.sys_back.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTableServiceImpl implements CheckTableService {
    @Autowired
    CheckTableMapper checkTableMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public int sendCheckTable(CheckTable checkTable) {

        if (patientMapper.selectByPrimaryKey(checkTable.getPatientId()) == null || doctorMapper.selectByPrimaryKey(checkTable.getDoctorId()) == null)
            return -1;
        else
            return checkTableMapper.insertSelective(checkTable);
    }


}
