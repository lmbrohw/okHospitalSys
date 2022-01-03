package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.CheckList;

import java.util.List;

public interface CheckListService {
    Float getCheckItemPriceById(String checkListId);
    List<CheckList> getCheckList();
}
