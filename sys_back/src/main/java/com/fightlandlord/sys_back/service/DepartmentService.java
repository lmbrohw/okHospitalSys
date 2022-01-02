package com.fightlandlord.sys_back.service;


import com.fightlandlord.sys_back.model.Department;

public interface DepartmentService {
    Department queryById(String departmentID);
}
