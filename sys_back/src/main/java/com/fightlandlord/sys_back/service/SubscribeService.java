package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Subscribe;

import java.util.List;

/**
 * @Author: hudongyue
 * @Description:
 * @DateTime: 2022/1/1 22:20
 */

public interface SubscribeService {

    Subscribe queryById(String subscribeId);

    List<Subscribe> getSubscribeListByPatientId(String patientId);

    int insertSubscribe(Subscribe subscribe);

    int modifyById(Subscribe subscribe);
}
