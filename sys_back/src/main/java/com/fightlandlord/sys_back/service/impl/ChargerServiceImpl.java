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
        if(tableId.length() < 2 || !tableId.substring(0, 2).equals("cg")) return null;
        return chargerMapper.selectByPrimaryKey(tableId);
    }

    @Override
    public int insertcharger(Charger charger) {
        if (queryById(charger.getChargerId()) == null) return 0;
        return chargerMapper.insert(charger);
    }

}
