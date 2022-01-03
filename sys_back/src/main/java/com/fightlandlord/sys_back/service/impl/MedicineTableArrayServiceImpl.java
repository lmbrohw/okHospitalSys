package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.MedicineTableArrayMapper;
import com.fightlandlord.sys_back.model.MedicineTableArray;
import com.fightlandlord.sys_back.service.MedicineTableArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineTableArrayServiceImpl implements MedicineTableArrayService {

    @Autowired
    MedicineTableArrayMapper medicineTableArrayMapper;

    @Override
    public List<MedicineTableArray> getMedicineTableByMedicineTableId(String medicineTableId) {
        return medicineTableArrayMapper.getMedicineTableByMedicineTableId(medicineTableId);
    }


    @Override
    public int addMedicineTableArray(MedicineTableArray medicineTableArray) {
        return medicineTableArrayMapper.insertSelective(medicineTableArray);
    }
}
