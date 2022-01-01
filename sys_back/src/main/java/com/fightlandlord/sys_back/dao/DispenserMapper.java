package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Dispenser;

public interface DispenserMapper {
    int deleteByPrimaryKey(String dispenserId);

    int insert(Dispenser record);

    int insertSelective(Dispenser record);

    Dispenser selectByPrimaryKey(String dispenserId);

    int updateByPrimaryKeySelective(Dispenser record);

    int updateByPrimaryKey(Dispenser record);
}