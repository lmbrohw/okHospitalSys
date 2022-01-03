package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargeTableMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.service.ChargeTableService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargeTableServiceImpl implements ChargeTableService {

    @Autowired
    ChargeTableMapper chargeTableMapper;

    @Override
    public ChargeTable queryById(String tableId) {
        return chargeTableMapper.selectByPrimaryKey(tableId);
    }

    @Override
    public int insertChargeTable(ChargeTable chargeTable) {
        return chargeTableMapper.insert(chargeTable);
    }
}
