package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.CheckTableArray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CheckTableArrayService {

    int addCheckTableArray(CheckTableArray checkTableArray);

    List<CheckTableArray> getCheckTableByCheckTableId(String checkTableId);
}
