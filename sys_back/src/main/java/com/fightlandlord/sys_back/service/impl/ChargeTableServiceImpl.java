package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargeTableMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.service.ChargeTableService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargeTableServiceImpl implements ChargeTableService {

    @Autowired
    ChargeTableMapper chargeTableMapper;

    @Override
    public ChargeTable queryById(String tableId) {
        return chargeTableMapper.selectByPrimaryKey(tableId);
    }

    @Override
    public int insertChargeTable(ChargeTable chargeTable) {
        return chargeTableMapper.insert(chargeTable);
    }

    @Override
    public Response modifyChargeTableState(String chargeTableId, int changeToState) {
        ChargeTable chargeTable = queryById(chargeTableId);
        if(chargeTable == null) return Response.error().message("不存在该chargeTable！");

        if(chargeTable.getChargeState() != 0 || changeToState != 1)
            return Response.error().message("无权限改变该chargeTable！");

        chargeTable.setChargeState(changeToState);

        if(chargeTableMapper.updateByPrimaryKeySelective(chargeTable) == 0)
            return Response.error().message("chanrgeTable插入数据库失败！");
        return Response.ok().message("改变chargeTable状态成功！");
    }
}
