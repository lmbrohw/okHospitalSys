package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.util.Response;

import java.util.Map;

public interface MedicineTableService {
    MedicineTable queryById(String medicineTableId);

    Map<String,Object> getMedicineTableJSON(MedicineTable medicineTable);

    MedicineTable getAMedicineTable(int role);

    Response modifyMedicineTableState(String medicineTableId, String roleId, int changeToState);

    int tmpModifyMedicineTableState(String medicineTableId, int state);

    int modifyById(MedicineTable medicineTable);

    int sendMedicineTable(MedicineTable medicineTable);


}
