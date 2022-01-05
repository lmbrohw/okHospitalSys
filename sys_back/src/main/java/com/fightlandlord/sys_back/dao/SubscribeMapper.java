package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.Subscribe;
import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface SubscribeMapper {
    int deleteByPrimaryKey(String subscribeId);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    Subscribe selectByPrimaryKey(String subscribeId);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);

    List<Subscribe> getSubscribeListByPatientId(String patientId);

    int getSubscribeNumBydoctorId(String doctorId, Date subscribeTime);
}