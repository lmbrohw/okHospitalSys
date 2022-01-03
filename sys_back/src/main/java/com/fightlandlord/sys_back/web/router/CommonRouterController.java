package com.fightlandlord.sys_back.web.router;

import com.fightlandlord.sys_back.model.Department;
import com.fightlandlord.sys_back.service.DepartmentService;
import com.fightlandlord.sys_back.service.DoctorService;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRouterController {
    
    @Autowired
    DoctorService doctorService;
    @Autowired
    DepartmentService departmentService;
    /**
    * @Author: hudongyue
    * @Description: 
    * @DateTime: 2021/12/28 16:26
    * @Params: 
    * @Return 
    */
    @GetMapping(value = "/getDoctorList")
    public Response getDoctorList(){
        return Response.ok().message("查询医生成功").data("doctorList", doctorService.getDoctorList());
    }

    @GetMapping(value = "/getDepartmentList")
    public Response getDepartment() {
        return Response.ok().message("查询科室成功").data("departmentList", departmentService.getDepartmentList());
    }

    @GetMapping(value = "/getExpertList")
    public Response getExpertList() {
        return Response.ok().message("查询专家成功").data("doctorList", doctorService.getExpertList());
    }
}



