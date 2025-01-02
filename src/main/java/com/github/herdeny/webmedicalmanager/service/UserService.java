package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.pojo.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {
    User selectUserByCode(int code);

    User selectUserByUsername(String username);

    void insertUser(String username, String password, BigInteger phone);

    void updateUser(User user);

    List<User> selectAllUser();

    PageBean<User> selectAllUserByPage(int page, int size);

    void deleteUser(int code);


}
