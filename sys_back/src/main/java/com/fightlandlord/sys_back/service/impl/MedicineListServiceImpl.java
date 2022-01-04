package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.MedicineListMapper;
import com.fightlandlord.sys_back.model.MedicineList;
import com.fightlandlord.sys_back.service.MedicineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineListServiceImpl implements MedicineListService {

    @Autowired
    MedicineListMapper medicineListMapper;

    @Override
    public MedicineList queryById(String medicineListId) {
        if(!medicineListId.substring(0, 2).equals("ml")) return null;
        return medicineListMapper.selectByPrimaryKey(medicineListId);
    }

    @Override
    public List<MedicineList> getMedicineList() {
        return medicineListMapper.getAll();
    }

    @Override
    public Float getMedicinePriceById(String medicineListId) {
        MedicineList medicineList = medicineListMapper.selectByPrimaryKey(medicineListId);
        if (medicineList == null){
            return -1f;
        }
        return medicineList.getMedicinePrice();
    }

    @Override
    public int updateMedicineNum(String medicineListId, Integer num) {
        MedicineList medicineList = medicineListMapper.selectByPrimaryKey(medicineListId);
        Integer oldNum = medicineList.getMedicineNum();
        medicineList.setMedicineNum(oldNum-num);
        return medicineListMapper.updateByPrimaryKeySelective(medicineList);
    }
}
