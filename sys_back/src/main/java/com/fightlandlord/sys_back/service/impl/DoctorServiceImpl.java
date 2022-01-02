package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DoctorMapper;
import com.fightlandlord.sys_back.model.Doctor;
import com.fightlandlord.sys_back.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public Doctor queryById(String doctorID) {
        return doctorMapper.selectByPrimaryKey(doctorID);
    }
}
