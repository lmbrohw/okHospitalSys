package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.CheckTable;
import com.fightlandlord.sys_back.model.MedicineTable;

import java.util.Map;

public interface CheckTableService {

    int sendCheckTable(CheckTable checkTable);

    Map<String,Object> getCheckTableJSON(CheckTable checkTable);

    CheckTable queryById(String checkTableId);

    int modifyCheckTableState(String medicineTableId, int state);
}
