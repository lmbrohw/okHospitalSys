package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DispenserMapper;
import com.fightlandlord.sys_back.model.Dispenser;
import com.fightlandlord.sys_back.service.DispenserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispenserServiceImpl implements DispenserService {

    @Autowired
    DispenserMapper dispenserMapper;

    @Override
    public Dispenser queryById(String dispenserId) {
        return dispenserMapper.selectByPrimaryKey(dispenserId);
    }
}
