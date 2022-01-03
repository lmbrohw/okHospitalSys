package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DossierTableMapper;
import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.dao.RegisterMapper;
import com.fightlandlord.sys_back.model.DossierTable;
import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.model.Register;
import com.fightlandlord.sys_back.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    DossierTableMapper dossierTableMapper;
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public Patient queryById(String patientId) {
        if(!patientId.substring(0, 2).equals("pt")) return null;
        return patientMapper.selectByPrimaryKey(patientId);
    }

    @Override
    public List<DossierTable> getPatientRecord(String patientID) {
        return dossierTableMapper.getDossierTableByPatientId(patientID);
    }

    @Override
    public Register getAPatient(String doctorId) {

        Register register = registerMapper.getAPatient(doctorId);
        if (register == null)
            return null;
        else{
            Register updatingRegister = new Register();
            updatingRegister.setRegisterId(register.getRegisterId());
            updatingRegister.setRegisterState(1);
            int a = registerMapper.updateByPrimaryKeySelective(updatingRegister);
            return register;
        }
    }
}
