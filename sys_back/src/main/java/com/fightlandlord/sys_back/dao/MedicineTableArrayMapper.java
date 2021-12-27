package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.MedicineTableArray;

public interface MedicineTableArrayMapper {
    int deleteByPrimaryKey(String medicineTableArrayId);

    int insert(MedicineTableArray record);

    int insertSelective(MedicineTableArray record);

    MedicineTableArray selectByPrimaryKey(String medicineTableArrayId);

    int updateByPrimaryKeySelective(MedicineTableArray record);

    int updateByPrimaryKey(MedicineTableArray record);
}