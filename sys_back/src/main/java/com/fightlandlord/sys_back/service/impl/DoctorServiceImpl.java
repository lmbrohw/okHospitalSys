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
    @Autowired
    RegisterMapper registerMapper;
    @Autowired
    CheckListMapper checkListMapper;
    @Autowired
    MedicineListMapper medicineListMapper;
    @Autowired
    CheckTableMapper checkTableMapper;
    @Autowired
    DossierTableMapper dossierTableMapper;
    @Autowired
    MedicineTableMapper medicineTableMapper;
    @Autowired
    CheckTableArrayMapper checkTableArrayMapper;
    @Autowired
    MedicineTableArrayMapper medicineTableArrayMapper;

    @Override
    public Doctor queryById(String doctorID) {
        return doctorMapper.selectByPrimaryKey(doctorID);
    }






















}

