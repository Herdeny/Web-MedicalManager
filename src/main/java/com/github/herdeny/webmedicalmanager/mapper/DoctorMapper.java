package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DoctorMapper {
    // 根据医生序号查询医生
    @Select("select * from doctor where code = #{code}")
    Doctor selectDoctorByCode(int code);
    //根据医生名字查询医生
    @Select("select * from doctor where name LIKE CONCAT('%', #{name}, '%')")
    List<Doctor> selectDoctorByName(String name);
    //根据科室序号查询医生
    @Select("select * from doctor where department_code = #{departmentCode}")
    List<Doctor> selectDoctorByDepartmentCode(int departmentCode);
    //根据科室名字查询医生
    @Select("select * from doctor where department_code = (select code from department where name = #{departmentName})")
    List<Doctor> selectDoctorByDepartmentName(String departmentName);
    //查询所有医生
    @Select("select * from doctor")
    List<Doctor> selectAllDoctor();
}
