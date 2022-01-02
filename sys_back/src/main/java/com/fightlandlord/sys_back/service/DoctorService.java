package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.*;

import java.util.List;

public interface DoctorService {
    Doctor queryById(String departmentID);
    Register getAPatient(String doctorId);
    List<CheckList> getCheckList();
    List<MedicineList> getMedicineList();
    int sendCheckTable(CheckTable checkTable);
}
