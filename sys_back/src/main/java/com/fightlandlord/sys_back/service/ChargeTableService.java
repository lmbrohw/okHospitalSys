package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.ChargeTable;
import org.springframework.stereotype.Service;

@Service
public interface ChargeTableService {

    ChargeTable queryById(String tableId);
}
