package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Patient;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {

    Patient queryById(String id);
}
