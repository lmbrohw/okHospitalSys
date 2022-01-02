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

    @Override
    public Register getAPatient(String doctorId) {

        Register register = registerMapper.getAPatient(doctorId);
        Register updatingRegister = new Register();
        updatingRegister.setRegisterId(register.getRegisterId());
        updatingRegister.setRegisterState(0);
        int a = registerMapper.updateByPrimaryKeySelective(updatingRegister);
        return register;
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
    public int sendDossierTable(DossierTable dossierTable) {
        return dossierTableMapper.insertSelective(dossierTable);
    }

    @Override
    public List<DossierTable> getPatientRecord(String patientID) {
        return dossierTableMapper.getDossierTableByPatientId(patientID);
    }

    @Override
    public Float getCheckItemPriceById(String checkListId) {
        CheckList checkListItem = checkListMapper.selectByPrimaryKey(checkListId);
        return checkListItem.getCheckPrice();
    }

    @Override
    public int sendCheckTable(CheckTable checkTable) {
        return checkTableMapper.insertSelective(checkTable);
    }

    @Override
    public Float getMedicinePriceById(String medicineListId) {
        MedicineList medicineList = medicineListMapper.selectByPrimaryKey(medicineListId);
        return medicineList.getMedicinePrice();
    }

    @Override
    public int sendMedicineTable(MedicineTable medicineTable) {
        return medicineTableMapper.insertSelective(medicineTable);
    }

    @Override
    public int addCheckTableArray(CheckTableArray checkTableArray) {
        return checkTableArrayMapper.insertSelective(checkTableArray);
    }

    @Override
    public int addMedicineTableArray(MedicineTableArray medicineTableArray) {
        return medicineTableArrayMapper.insertSelective(medicineTableArray);
    }

}

