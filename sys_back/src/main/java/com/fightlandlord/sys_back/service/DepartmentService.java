package com.fightlandlord.sys_back.service;


import com.fightlandlord.sys_back.model.Department;

import java.util.List;

public interface DepartmentService {
    Department queryById(String departmentID);

    List<Department> getDepartmentList();
}
