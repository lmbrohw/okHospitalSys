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
}
