package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.*;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.DoctorService;
import com.fightlandlord.sys_back.service.MedicineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public Doctor queryById(String doctorID) {
        return doctorMapper.selectByPrimaryKey(doctorID);
    }

    @Override
    public List<Doctor> getDoctorList() {
        return doctorMapper.getAll();
    }

    @Override
    public List<Doctor> getExpertList() {
        return doctorMapper.getExpertList();
    }


}

