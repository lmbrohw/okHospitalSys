package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.ChargeTableMapper;
import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.MedicineTable;
import com.fightlandlord.sys_back.model.Register;
import com.fightlandlord.sys_back.service.*;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChargeTableServiceImpl implements ChargeTableService {

    @Autowired
    ChargerService chargerService;

    @Autowired
    ChargeTableMapper chargeTableMapper;

    @Autowired
    RegisterService registerService;

    @Autowired
    MedicineTableService medicineTableService;

    @Autowired
    CheckTableService checkTableService;

    @Override
    public ChargeTable queryById(String tableId) {
        return chargeTableMapper.selectByPrimaryKey(tableId);
    }

    @Override
    public int insertChargeTable(ChargeTable chargeTable) {
        return chargeTableMapper.insert(chargeTable);
    }

    @Override
    public Response modifyChargeTableState(String chargeTableId, String chargerId, int changeToState) {
        ChargeTable chargeTable = queryById(chargeTableId);
        if(chargeTable == null) return Response.error().message("不存在该chargeTable！");
        if(chargerService.queryById(chargerId) == null) return Response.error().message("不存在该charger");

        if(chargeTable.getChargeState() != 0 || changeToState != 1)
            return Response.error().message("无权限改变该chargeTable！");

        chargeTable.setChargerId(chargerId);
        chargeTable.setChargeState(changeToState);

        String prefix = chargeTableId.substring(0, 2);
        if(prefix.equals("rg")) { // register
            if(registerService.modifyRegisterState(chargeTableId, 1) == 0)
                return Response.error().message("插入数据库失败！");
        } else if(prefix.equals("mt")) { // medicineTable
            if(medicineTableService.tmpModifyMedicineTableState(chargeTableId, 1) == 0)
                return Response.error().message("插入数据库失败！");
        } else if(prefix.equals("ct")) { // checkTablet
            if(checkTableService.modifyCheckTableState(chargeTableId, 1) == 0)
                return Response.error().message("插入数据库失败！");
        } else if(prefix.equals("wm")) { // withdrawMedicineTable

        }


        if(chargeTableMapper.updateByPrimaryKeySelective(chargeTable) == 0)
            return Response.error().message("chanrgeTable插入数据库失败！");
        return Response.ok().message("改变chargeTable状态成功！");
    }
}
