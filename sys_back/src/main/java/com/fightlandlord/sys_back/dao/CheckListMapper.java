package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.CheckList;

public interface CheckListMapper {
    int deleteByPrimaryKey(String checkListId);

    int insert(CheckList record);

    int insertSelective(CheckList record);

    CheckList selectByPrimaryKey(String checkListId);

    int updateByPrimaryKeySelective(CheckList record);

    int updateByPrimaryKey(CheckList record);
}