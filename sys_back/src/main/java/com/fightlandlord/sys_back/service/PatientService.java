package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.DossierTable;
import com.fightlandlord.sys_back.model.Patient;
import com.fightlandlord.sys_back.model.Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    Patient queryById(String id);

    Register getAPatient(String doctorId);
    List<DossierTable> getPatientRecord(String patientID);
}
