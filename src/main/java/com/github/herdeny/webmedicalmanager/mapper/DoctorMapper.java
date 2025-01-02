package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import org.apache.ibatis.annotations.*;

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

    //新增医生信息
    @Insert("insert into doctor(name,gender,department_code,avatar,description,title,age) values(#{name},#{gender},#{departmentCode},#{avatar},#{description},#{title},#{age})")
    void insertDoctor(Doctor doctor);

    //更新医生信息
    void updateDoctor(Doctor doctor);

    //删除医生信息
    @Delete("delete from doctor where code = #{code}")
    void deleteDoctorByCode(int code);
}
