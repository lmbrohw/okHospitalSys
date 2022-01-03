package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.CheckTableMapper;
import com.fightlandlord.sys_back.model.CheckTable;
import com.fightlandlord.sys_back.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTableServiceImpl implements CheckTableService {
    @Autowired
    CheckTableMapper checkTableMapper;
    @Override
    public int sendCheckTable(CheckTable checkTable) {
        return checkTableMapper.insertSelective(checkTable);
    }


}
