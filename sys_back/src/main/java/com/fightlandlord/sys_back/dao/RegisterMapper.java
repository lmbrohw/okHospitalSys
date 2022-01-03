package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Register;

import java.sql.Time;
import java.util.List;

public interface RegisterMapper {
    int deleteByPrimaryKey(String registerId);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String registerId);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    Register getAPatient(String doctorId);

    List<Register> getRegistRecordByPatientId(String patientID);
}