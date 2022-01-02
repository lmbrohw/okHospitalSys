package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Doctor;

public interface DoctorService {
    Doctor queryById(String departmentID);
}
