package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.MedicineListMapper;
import com.fightlandlord.sys_back.model.MedicineList;
import com.fightlandlord.sys_back.service.MedicineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineListServiceImpl implements MedicineListService {

    @Autowired
    MedicineListMapper medicineListMapper;

    @Override
    public MedicineList queryById(String medicineListId) {
        return medicineListMapper.selectByPrimaryKey(medicineListId);
    }
}
