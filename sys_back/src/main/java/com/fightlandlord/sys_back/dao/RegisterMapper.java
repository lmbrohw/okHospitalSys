package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(String registerId);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String registerId);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}