package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.MedicineTableArray;

import java.util.List;

public interface MedicineTableArrayService {
    List<MedicineTableArray> getMedicineTableByMedicineTableId(String medicineTableId);
}
