package com.fightlandlord.sys_back.service.impl;

import com.fightlandlord.sys_back.dao.DepartmentMapper;
import com.fightlandlord.sys_back.model.Department;
import com.fightlandlord.sys_back.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department queryById(String departmentID) {
        if(departmentID.length() < 2 || !departmentID.substring(0, 2).equals("dp")) return null;
        return departmentMapper.selectByPrimaryKey(departmentID);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }
}
