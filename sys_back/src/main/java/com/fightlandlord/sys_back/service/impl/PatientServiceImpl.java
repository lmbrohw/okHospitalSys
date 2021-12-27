package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient queryById(String id) {
        return patientMapper.selectByPrimaryKey(id);
    }
}
