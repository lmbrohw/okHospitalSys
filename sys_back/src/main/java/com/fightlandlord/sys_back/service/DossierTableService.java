package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.DossierTable;

public interface DossierTableService {
    int sendDossierTable(DossierTable dossierTable);
    DossierTable queryById(String dossierTableId);

}
