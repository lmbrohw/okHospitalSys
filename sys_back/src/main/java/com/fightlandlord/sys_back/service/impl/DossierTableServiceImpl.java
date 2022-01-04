package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DoctorMapper;
import com.fightlandlord.sys_back.dao.DossierTableMapper;
import com.fightlandlord.sys_back.dao.PatientMapper;
import com.fightlandlord.sys_back.model.DossierTable;
import com.fightlandlord.sys_back.service.DossierTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierTableServiceImpl implements DossierTableService {
    @Autowired
    DossierTableMapper dossierTableMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Override
    public int sendDossierTable(DossierTable dossierTable) {

        //该处方单的doctorId和patientId有误
        if (patientMapper.selectByPrimaryKey(dossierTable.getPatientId()) == null || doctorMapper.selectByPrimaryKey(dossierTable.getDoctorId()) == null)
            return -1;
        else
            return dossierTableMapper.insertSelective(dossierTable);
    }

    @Override
    public DossierTable queryById(String dossierTableId) {
        if(dossierTableId.length() < 2 || !dossierTableId.substring(0, 2).equals("dt")) return null;
        return dossierTableMapper.selectByPrimaryKey(dossierTableId);
    }

}
