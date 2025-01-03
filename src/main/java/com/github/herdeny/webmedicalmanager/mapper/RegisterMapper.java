package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.RegisterStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface RegisterMapper {
    void insertRegister(int doctorCode, int UserCode, Date visitTime, String remark);

    @Update("update register set status = #{status} where code = #{code}")
    void updateRegisterStatus(int code, RegisterStatus status);

    @Delete("delete from register where code = #{code}")
    void deleteRegister(int code);

    @Select("select count(*) from register where date_format(reg_time, '%Y-%m-%d') = #{date}")
    int countDay(String date);

    @Select("select count(*) from register where date_format(reg_time, '%Y-%m') = #{date}")
    int countMonth(String date);

    //查询日就诊科室分布
    @Select("select department_code,count(*) from register,doctor where date_format(reg_time, '%Y-%m-%d') = #{date} and register.doctor_code = doctor.code Group by department_code")
    List<Map<Integer, Integer>> countDepartment(String date);

    //统计日平均等待时间
    @Select("select avg(visit_time-reg_time)/60 from register where date_format(reg_time, '%Y-%m-%d') = #{date}")
    int countWaitDay(String date);


}
