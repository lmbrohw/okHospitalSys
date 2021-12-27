package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.MedicineTable;

public interface MedicineTableMapper {
    int deleteByPrimaryKey(String medicineTableId);

    int insert(MedicineTable record);

    int insertSelective(MedicineTable record);

    MedicineTable selectByPrimaryKey(String medicineTableId);

    int updateByPrimaryKeySelective(MedicineTable record);

    int updateByPrimaryKey(MedicineTable record);
}