package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.WithdrawMedicineTable;

public interface WithdrawMedicineTableMapper {
    int deleteByPrimaryKey(String withdrawMedicineTableId);

    int insert(WithdrawMedicineTable record);

    int insertSelective(WithdrawMedicineTable record);

    WithdrawMedicineTable selectByPrimaryKey(String withdrawMedicineTableId);

    int updateByPrimaryKeySelective(WithdrawMedicineTable record);

    int updateByPrimaryKey(WithdrawMedicineTable record);
}