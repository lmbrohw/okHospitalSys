package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.CheckTableArray;

import java.util.List;

public interface CheckTableArrayMapper {
    int deleteByPrimaryKey(String checkTableArrayId);

    int insert(CheckTableArray record);

    int insertSelective(CheckTableArray record);

    CheckTableArray selectByPrimaryKey(String checkTableArrayId);

    int updateByPrimaryKeySelective(CheckTableArray record);

    int updateByPrimaryKey(CheckTableArray record);

    List<CheckTableArray> getCheckTableByCheckTableId(String checkTableId);
}