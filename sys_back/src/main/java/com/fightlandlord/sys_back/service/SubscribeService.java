package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.ChargeTable;
import com.fightlandlord.sys_back.model.Subscribe;

import java.util.List;

public interface SubscribeService {

    Subscribe queryById(String subscribeId);

    List<Subscribe> getSubscribeListByPatientId(String patientId);

    int insertSubscribe(Subscribe subscribe);

    int modifyById(Subscribe subscribe);
}
