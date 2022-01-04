package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.PharmacistMapper;
import com.fightlandlord.sys_back.model.Pharmacist;
import com.fightlandlord.sys_back.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    PharmacistMapper pharmacistMapper;

    @Override
    public Pharmacist queryById(String pharmacistId) {
        if(!pharmacistId.substring(0, 2).equals("pm")) return null;
        return pharmacistMapper.selectByPrimaryKey(pharmacistId);
    }

    @Override
    public int insertPharmacist(Pharmacist pharmacist) {
        if (queryById(pharmacist.getPharmacistId()) == null) return 0;
        return pharmacistMapper.insert(pharmacist);
    }
}
