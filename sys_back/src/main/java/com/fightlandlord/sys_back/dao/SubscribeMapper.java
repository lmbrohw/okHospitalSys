package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Subscribe;

import java.util.List;

public interface SubscribeMapper {
    int deleteByPrimaryKey(String subscribeId);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    Subscribe selectByPrimaryKey(String subscribeId);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);

    List<Subscribe> getSubscribeListByPatientId(String patientId);
}