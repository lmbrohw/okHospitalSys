package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.MedicineList;

public interface MedicineListMapper {
    int deleteByPrimaryKey(String medicineListId);

    int insert(MedicineList record);

    int insertSelective(MedicineList record);

    MedicineList selectByPrimaryKey(String medicineListId);

    int updateByPrimaryKeySelective(MedicineList record);

    int updateByPrimaryKey(MedicineList record);
}