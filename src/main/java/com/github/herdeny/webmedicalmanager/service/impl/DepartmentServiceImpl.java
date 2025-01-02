package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.DepartmentMapper;
import com.github.herdeny.webmedicalmanager.pojo.Department;
import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department selectDepartmentByCode(int code) {
        return departmentMapper.selectDepartmentByCode(code);
    }

    @Override
    public List<Department> selectDepartmentByName(String name) {
        return departmentMapper.selectDepartmentByName(name);
    }

    @Override
    public List<Department> selectDepartmentByAddress(String address) {
        return departmentMapper.selectDepartmentByAddress(address);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }


    @Override
    public PageBean<Department> selectAllDepartmentPage(int page, int size) {
        PageBean<Department> pageBean = new PageBean<>();
        PageHelper.startPage(page, size);
        List<Department> departments = departmentMapper.selectAllDepartment();
        Page<Department> departmentPage = (Page<Department>) departments;
        pageBean.setTotal(departmentPage.getTotal());
        pageBean.setItems(departmentPage.getResult());
        return pageBean;
    }
}
