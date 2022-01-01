package com.fightlandlord.sys_back.dao;

import com.fightlandlord.sys_back.model.ChargeTable;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

public interface ChargeTableMapper {
    int deleteByPrimaryKey(String chargeTableId);

    int insert(ChargeTable record);

    int insertSelective(ChargeTable record);

    ChargeTable selectByPrimaryKey(String chargeTableId);

    int updateByPrimaryKeySelective(ChargeTable record);

    int updateByPrimaryKey(ChargeTable record);
}