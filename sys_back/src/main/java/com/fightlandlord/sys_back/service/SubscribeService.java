package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Subscribe;

/**
 * @Author: hudongyue
 * @Description:
 * @DateTime: 2022/1/1 22:20
 */

public interface SubscribeService {

    Subscribe queryById(String subscribeID);

    int insertSubscribe(Subscribe subscribe);

    int modifyById(Subscribe subscribe);
}
