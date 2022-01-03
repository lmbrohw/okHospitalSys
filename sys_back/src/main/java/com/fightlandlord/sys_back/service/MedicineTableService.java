package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.MedicineTable;

public interface MedicineTableService {
    MedicineTable queryById(String medicineTableId);

    MedicineTable getAMedicineTableForDispenser();

    int modifyById(MedicineTable medicineTable);

    MedicineTable getAMedicineTableForPharmacist();

    int sendMedicineTable(MedicineTable medicineTable);
}
