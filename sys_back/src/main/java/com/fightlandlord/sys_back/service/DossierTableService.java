package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.DossierTable;

import java.util.List;

public interface DossierTableService {
    int sendDossierTable(DossierTable dossierTable);
    DossierTable getDossierTableRecordById(String dossierTableId);

}
