package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.Charger;

public interface ChargerService {
    Charger queryById(String chargerId);

    int insertcharger(Charger charger);
}
