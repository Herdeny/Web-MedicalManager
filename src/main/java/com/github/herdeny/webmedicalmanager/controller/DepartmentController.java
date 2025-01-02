package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.Department;
import com.github.herdeny.webmedicalmanager.pojo.Result;
import com.github.herdeny.webmedicalmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
@Validated
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    ///通过序号查询科室信息
    @RequestMapping("/departInfo/byCode")
    public Result<Department> selectDepartInfoByCode(Integer code) {
        return Result.success(departmentService.selectDepartmentByCode(code));
    }

    ///通过名称查询科室信息
    @RequestMapping("/departInfo/byName")
    public Result<List<Department>> selectDepartmentInfoByName(String name) {
        return Result.success(departmentService.selectDepartmentByName(name));
    }

    ///通过地址查询科室信息
    @RequestMapping("/departInfo/byAddress")
    public Result<List<Department>> selectDepartmentInfoByAddress(String address) {
        return Result.success(departmentService.selectDepartmentByAddress(address));
    }

    ///查询所有科室信息
    @RequestMapping("/departInfo/all")
    public Result<List<Department>> selectAllDepartmentInfo() {
        return Result.success(departmentService.selectAllDepartment());
    }

    ///分页查询科室信息
    @RequestMapping("/departInfo/all/page")
    public Result<List<Department>> selectAllDepartmentInfoByPage(int page, int size) {
        return Result.success(departmentService.selectAllDepartmentPage(page, size).getItems());
    }


}
