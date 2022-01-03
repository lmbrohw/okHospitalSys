package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.util.Response;

public interface ChargeTableService {

    ChargeTable queryById(String tableId);

    int insertChargeTable(ChargeTable chargeTable);

    Response modifyChargeTableState(String chargeTableId, int changeToState);
}
