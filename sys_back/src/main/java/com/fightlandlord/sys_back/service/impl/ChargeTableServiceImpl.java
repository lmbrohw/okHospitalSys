package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargeTableMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.service.ChargeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ChargeTableServiceImpl implements ChargeTableService {

    ChargeTableMapper chargeTableMapper;

    @Override
    public ChargeTable queryById(String tableId) {
        return chargeTableMapper.selectByPrimaryKey(tableId);
    }
}
