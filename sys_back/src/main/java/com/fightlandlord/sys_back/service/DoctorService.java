package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.*;

import java.util.List;

public interface DoctorService {
    Doctor queryById(String departmentID);
    List<Doctor> getDoctorList();
    List<Doctor> getExpertList();
    int insertDoctor(Doctor doctor);









}
