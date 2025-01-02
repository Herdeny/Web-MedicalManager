package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Department;
import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;

import java.util.List;

public interface DepartmentService {
    Department selectDepartmentByCode(int code);

    List<Department> selectDepartmentByName(String name);

    List<Department> selectDepartmentByAddress(String address);

    List<Department> selectAllDepartment();

    PageBean<Department> selectAllDepartmentPage(int page, int size);
}
