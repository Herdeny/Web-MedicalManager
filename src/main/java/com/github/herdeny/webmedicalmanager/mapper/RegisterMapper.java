package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.RegisterStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Mapper
public interface RegisterMapper {
    void insertRegister(int doctorCode,int UserCode ,Date visitTime, String remark);

    @Update("update register set status = #{status} where code = #{code}")
    void updateRegisterStatus(int code, RegisterStatus status);

    @Delete("delete from register where code = #{code}")
    void deleteRegister(int code);

    @Select("select count(*) from register where date_format(reg_time, '%Y-%m-%d') = #{time}")
    int countDay(String date);
}
