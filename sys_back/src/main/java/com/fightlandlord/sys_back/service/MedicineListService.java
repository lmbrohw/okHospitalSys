package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.MedicineList;

import java.util.List;

public interface MedicineListService {
    MedicineList queryById(String medicineListId);
    Float getMedicinePriceById(String medicineListId);
    List<MedicineList> getMedicineList();
    int updateMedicineNum(String medicineListId, Integer num);

    float queryInventoryById(String medicineList);
}
