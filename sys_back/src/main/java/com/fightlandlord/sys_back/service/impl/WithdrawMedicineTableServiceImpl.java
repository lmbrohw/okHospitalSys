package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.WithdrawMedicineTableMapper;
import com.fightlandlord.sys_back.model.WithdrawMedicineTable;
import com.fightlandlord.sys_back.service.WithdrawMedicineTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawMedicineTableServiceImpl implements WithdrawMedicineTableService {

    @Autowired
    WithdrawMedicineTableMapper withdrawMedicineTableMapper;

    @Override
    public int sendWithdrawMedicineTable(WithdrawMedicineTable withdrawMedicineTable) {
        return withdrawMedicineTableMapper.insert(withdrawMedicineTable);
    }
}
