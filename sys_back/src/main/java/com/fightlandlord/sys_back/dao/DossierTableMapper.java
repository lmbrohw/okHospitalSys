package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.DossierTable;

public interface DossierTableMapper {
    int deleteByPrimaryKey(String dossierTableId);

    int insert(DossierTable record);

    int insertSelective(DossierTable record);

    DossierTable selectByPrimaryKey(String dossierTableId);

    int updateByPrimaryKeySelective(DossierTable record);

    int updateByPrimaryKey(DossierTable record);
}