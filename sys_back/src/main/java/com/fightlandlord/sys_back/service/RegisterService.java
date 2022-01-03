package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Register;

import java.util.List;

public interface RegisterService {
    List<Register> getRegisterByPatientId(String patientId);
}
