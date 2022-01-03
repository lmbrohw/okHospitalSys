package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.WithdrawMedicineTableArrayMapper;
import com.fightlandlord.sys_back.model.WithdrawMedicineTableArray;
import com.fightlandlord.sys_back.service.WithdrawMedicineTableArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawMedicineTableArrayServiceImpl implements WithdrawMedicineTableArrayService {

    @Autowired
    WithdrawMedicineTableArrayMapper withdrawMedicineTableArrayMapper;

    @Override
    public int sendWithdrawMedicineTableArray(WithdrawMedicineTableArray withdrawMedicineTableArray) {
        return withdrawMedicineTableArrayMapper.insert(withdrawMedicineTableArray);
    }
}
