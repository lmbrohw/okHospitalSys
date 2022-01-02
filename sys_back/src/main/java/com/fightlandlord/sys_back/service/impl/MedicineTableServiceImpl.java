package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.MedicineTableMapper;
import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.service.MedicineTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineTableServiceImpl implements MedicineTableService {

    @Autowired
    MedicineTableMapper medicineTableMapper;

    @Override
    public MedicineTable queryById(String medicineTableId) {
        return medicineTableMapper.selectByPrimaryKey(medicineTableId);
    }

    @Override
    public MedicineTable getAMedicineTableForDispenser() {
        return medicineTableMapper.getAMedicineTableForDispenser();
    }

    @Override
    public int modifyById(MedicineTable medicineTable) {
        return medicineTableMapper.updateByPrimaryKeySelective(medicineTable);
    }

    @Override
    public MedicineTable getAMedicineTableForPharmacist() {
        return medicineTableMapper.getAMedicineTableForPharmacist();
    }
}
