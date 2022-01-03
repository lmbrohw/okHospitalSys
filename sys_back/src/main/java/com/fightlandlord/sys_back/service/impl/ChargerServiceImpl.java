package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargerMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Charger;
import com.fightlandlord.sys_back.service.ChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargerServiceImpl implements ChargerService {

    @Autowired
    ChargerMapper chargerMapper;

    @Override
    public Charger queryById(String tableId) {
        return chargerMapper.selectByPrimaryKey(tableId);
    }
}
