package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Blacklist;

public interface BlacklistMapper {
    int deleteByPrimaryKey(String blacklistId);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    Blacklist selectByPrimaryKey(String blacklistId);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}