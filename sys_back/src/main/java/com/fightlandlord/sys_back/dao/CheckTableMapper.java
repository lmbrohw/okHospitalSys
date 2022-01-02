package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.CheckTable;

public interface CheckTableMapper {
    int deleteByPrimaryKey(String checkTableId);

    int insert(CheckTable record);

    int insertSelective(CheckTable record);

    CheckTable selectByPrimaryKey(String checkTableId);

    int updateByPrimaryKeySelective(CheckTable record);

    int updateByPrimaryKey(CheckTable record);


}