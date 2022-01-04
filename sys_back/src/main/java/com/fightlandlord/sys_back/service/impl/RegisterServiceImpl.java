package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.RegisterMapper;
import com.fightlandlord.sys_back.model.Register;
import com.fightlandlord.sys_back.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public List<Register> getRegisterByPatientId(String patientId) {
        return registerMapper.getRegistRecordByPatientId(patientId);
    }

    @Override
    public int insertRegister(Register register) {
        return registerMapper.insert(register);
    }

    @Override
    public Register queryById(String registerId) {
        if(registerId.length() < 2 || !registerId.substring(0, 2).equals("rg")) return null;
        return registerMapper.selectByPrimaryKey(registerId);
    }

    @Override
    public int modifyRegisterState(String registerId, int state) {
        Register register = queryById(registerId);
        if(register == null) return 0;
        register.setRegisterState(state);
        return registerMapper.updateByPrimaryKeySelective(register);
    }

    @Override
    public int addTreatInfo(Register register) {
        return registerMapper.updateByPrimaryKeySelective(register);
    }

    @Override
    public Register queryByMedicneId(String medicineTableId) {
        if(!medicineTableId.substring(0, 2).equals("mt")) return null;
        return registerMapper.selectByMedicineTableId(medicineTableId);
    }


}
