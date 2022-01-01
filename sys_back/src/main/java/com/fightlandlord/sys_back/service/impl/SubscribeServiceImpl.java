package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.SubscribeMapper;
import com.fightlandlord.sys_back.model.Subscribe;
import com.fightlandlord.sys_back.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    SubscribeMapper subscribeMapper;

    @Override
    public int insertSubscribe(Subscribe subscribe) {
        return subscribeMapper.insertSelective(subscribe);
    }
}
