package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.UserMapper;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.pojo.User;
import com.github.herdeny.webmedicalmanager.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByCode(int code) {
        return userMapper.selectUserByCode(code);
    }

    @Override
    public User selectUserByUsername(String userName) {
        return userMapper.selectUserByUsername(userName);
    }

    @Override
    public void insertUser(String username, String password, BigInteger phone) {
        userMapper.insertUser(username, password, phone);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public PageBean<User> selectAllUserByPage(int page, int size) {
        PageBean<User> pageBean = new PageBean<>();
        PageHelper.startPage(page, size);
        List<User> users = userMapper.selectAllUser();
        Page<User> userPage = (Page<User>) users;
        pageBean.setTotal(userPage.getTotal());
        pageBean.setItems(userPage.getResult());
        return pageBean;

    }

    public void deleteUser(int code) {
        userMapper.deleteUserByCode(code);
    }


}
