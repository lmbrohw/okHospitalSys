package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Pharmacist;

public interface PharmacistMapper {
    int deleteByPrimaryKey(String pharmacistId);

    int insert(Pharmacist record);

    int insertSelective(Pharmacist record);

    Pharmacist selectByPrimaryKey(String pharmacistId);

    int updateByPrimaryKeySelective(Pharmacist record);

    int updateByPrimaryKey(Pharmacist record);
}