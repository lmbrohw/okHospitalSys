package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.*;
import com.fightlandlord.sys_back.model.*;
import com.fightlandlord.sys_back.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    RegisterMapper registerMapper;
    @Autowired
    CheckListMapper checkListMapper;
    @Autowired
    MedicineListMapper medicineListMapper;
    @Autowired
    CheckTableMapper checkTableMapper;

    @Override
    public Doctor queryById(String doctorID) {
        return doctorMapper.selectByPrimaryKey(doctorID);
    }

    @Override
    public Register getAPatient(String doctorId) {
        return registerMapper.getAPatient(doctorId);
    }

    @Override
    public List<CheckList> getCheckList() {
        return (List<CheckList>) checkListMapper.getAll();
    }

    @Override
    public List<MedicineList> getMedicineList() {
        return medicineListMapper.getAll();
    }

    @Override
    public int sendCheckTable(CheckTable checkTable) {
        return checkTableMapper.insert(checkTable);
    }
}

