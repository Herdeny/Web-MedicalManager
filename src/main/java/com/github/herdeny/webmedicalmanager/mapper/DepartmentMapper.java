package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    //根据科室序号查询科室
    @Select("select * from department where code = #{code}")
    Department selectDepartmentByCode(int code);

    //根据科室名称查询科室
    @Select("select * from department where name LIKE concat('%', #{name}, '%')")
    List<Department> selectDepartmentByName(String name);

    //根据地址查询科室
    @Select("select * from department where address LIKE concat('%', #{address}, '%')")
    List<Department> selectDepartmentByAddress(String address);

    //查询所有科室
    @Select("select * from department")
    List<Department> selectAllDepartment();


}
