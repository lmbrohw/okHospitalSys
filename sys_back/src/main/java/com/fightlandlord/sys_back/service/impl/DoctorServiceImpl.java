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
        if(doctorID.length() < 2 || !doctorID.substring(0, 2).equals("dt")) return null;
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

    @Override
    public int insertDoctor(Doctor doctor) {
        if(queryById(doctor.getDoctorId()) != null) return 0;
        return doctorMapper.insert(doctor);
    }


}

