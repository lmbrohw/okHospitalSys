package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.CheckTableArrayMapper;
import com.fightlandlord.sys_back.model.CheckTableArray;
import com.fightlandlord.sys_back.service.CheckTableArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTableArrayServiceImpl implements CheckTableArrayService {
    @Autowired
    CheckTableArrayMapper checkTableArrayMapper;

    @Override
    public int addCheckTableArray(CheckTableArray checkTableArray) {
        return checkTableArrayMapper.insertSelective(checkTableArray);
    }
}
