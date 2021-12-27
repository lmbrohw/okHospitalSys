package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.WithdrawMedicineTableArray;

public interface WithdrawMedicineTableArrayMapper {
    int deleteByPrimaryKey(String withdrawMedicineTableArrayId);

    int insert(WithdrawMedicineTableArray record);

    int insertSelective(WithdrawMedicineTableArray record);

    WithdrawMedicineTableArray selectByPrimaryKey(String withdrawMedicineTableArrayId);

    int updateByPrimaryKeySelective(WithdrawMedicineTableArray record);

    int updateByPrimaryKey(WithdrawMedicineTableArray record);
}