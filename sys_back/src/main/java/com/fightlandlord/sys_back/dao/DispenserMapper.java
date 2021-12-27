package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Dispenser;

public interface DispenserMapper {
    int deleteByPrimaryKey(String disperserId);

    int insert(Dispenser record);

    int insertSelective(Dispenser record);

    Dispenser selectByPrimaryKey(String disperserId);

    int updateByPrimaryKeySelective(Dispenser record);

    int updateByPrimaryKey(Dispenser record);
}