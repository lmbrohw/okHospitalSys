package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Pharmacist;

public interface PharmacistService {
    Pharmacist queryById(String pharmacistId);
    int insertPharmacist(Pharmacist pharmacist);
}
