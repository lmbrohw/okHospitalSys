package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.CheckListMapper;
import com.fightlandlord.sys_back.model.CheckList;
import com.fightlandlord.sys_back.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckListServiceImpl implements CheckListService {

    @Autowired
    CheckListMapper checkListMapper;


    @Override
    public Float getCheckItemPriceById(String checkListId) {
        CheckList checkListItem = checkListMapper.selectByPrimaryKey(checkListId);
        return checkListItem.getCheckPrice();
    }

    @Override
    public List<CheckList> getCheckList() {
        return (List<CheckList>) checkListMapper.getAll();
    }
}
