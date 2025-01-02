package com.github.herdeny.webmedicalmanager.mapper;

import com.github.herdeny.webmedicalmanager.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户序号查询用户
    @Select("select * from user where code = #{code}")
    User selectUserByCode(int code);

    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User selectUserByUsername(String username);

    //根据姓名查询用户
    @Select("select * from user where name LIKE CONCAT('%', #{name}, '%')")
    List<User> selectUserByName(String name);

    //添加用户
    @Insert("insert into user(username,password,phone) values (#{username},#{password},#{phone})")
    void insertUser(String username, String password, BigInteger phone);

    //更新用户
    void updateUser(User user);

    //查询全部用户
    @Select("select * from user")
    List<User> selectAllUser();

    // 获取全部用户数量
    @Select("select count(*) from user")
    int selectAllUserCount();

    // 获取月用户数量
    @Select("select count(*) from user where date_format(reg_time, '%Y-%m') = #{time}")
    int selectMonthUserCount(String month);

    //删除用户
    @Delete("delete from user where code = #{code}")
    void deleteUserByCode(int code);


}
