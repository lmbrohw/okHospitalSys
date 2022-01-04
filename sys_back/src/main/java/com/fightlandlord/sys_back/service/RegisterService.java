package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Register;

import java.util.List;

public interface RegisterService {
    List<Register> getRegisterByPatientId(String patientId);

    int insertRegister(Register register);

    Register queryById(String registerId);

    int modifyRegisterState(String registerId, int state);

    int addTreatInfo(Register register);

    Register queryByMedicneId(String medicineId);
}
