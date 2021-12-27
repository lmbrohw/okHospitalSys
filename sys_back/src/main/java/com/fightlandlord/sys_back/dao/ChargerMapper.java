package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Charger;

public interface ChargerMapper {
    int deleteByPrimaryKey(String chargerId);

    int insert(Charger record);

    int insertSelective(Charger record);

    Charger selectByPrimaryKey(String chargerId);

    int updateByPrimaryKeySelective(Charger record);

    int updateByPrimaryKey(Charger record);
}