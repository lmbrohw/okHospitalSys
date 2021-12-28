package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargeTableMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.service.ChargeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
public class ChargeTableServiceImpl implements ChargeTableService {

=======
@Service
public class ChargeTableServiceImpl implements ChargeTableService {

    @Autowired
>>>>>>> 75e2df208f874b09d79dec13919cfefb5607bc41
    ChargeTableMapper chargeTableMapper;

    @Override
    public ChargeTable queryById(String tableId) {
        return chargeTableMapper.selectByPrimaryKey(tableId);
    }
}
