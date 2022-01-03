package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Doctor;

import java.util.List;

public interface DoctorMapper {
    int deleteByPrimaryKey(String doctorId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String doctorId);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    List<Doctor> getAll();

    List<Doctor> getExpertList();
}