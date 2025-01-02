package com.github.herdeny.webmedicalmanager.controller;


import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.utils.JwtUtil;
import com.github.herdeny.webmedicalmanager.utils.Md5Util;
import com.github.herdeny.webmedicalmanager.pojo.Result;
import com.github.herdeny.webmedicalmanager.pojo.User;
import com.github.herdeny.webmedicalmanager.service.UserService;
import com.github.herdeny.webmedicalmanager.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    // 204-用户名已存在
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String password, @Pattern(regexp = "^1[3456789]\\d{9}$") BigInteger phone) {
        //查询用户
        User u = userService.selectUserByUsername(username);
        if (u == null) {
            //未占用，返回为空
            userService.insertUser(username, Md5Util.getMD5String(password), phone); //注册
            return Result.success(); //返回结果
        } else return Result.fail(204);
    }

    //找回密码
    // 201-用户名手机号不匹配
    // 202-用户名不存在
    @PostMapping("/recovery")
    public Result recovery(@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String password, @Pattern(regexp = "^1[3456789]\\d{9}$") BigInteger phone) {
        //查询用户
        User u = userService.selectUserByUsername(username);
        if (u != null) {
            if (u.getPhone().equals(phone)) {
                u.setPassword(password);
                userService.updateUser(u); //注册
                return Result.success(); //返回结果
            } else return Result.fail(201);
        } else return Result.fail(202);
    }

    //登录
    // 202-用户名不存在
    // 203-密码错误
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String password) {
        //查询用户
        User u = userService.selectUserByUsername(username);
        if (u == null) {
            //用户不存在
            return Result.fail(202);
        } else if (!u.getPassword().equals(Md5Util.getMD5String(password))) {
            //密码错误
            return Result.fail(203);
        } else {
            //登录成功
            //生成token
            Map<String, Object> UserMap = new HashMap<>();
            UserMap.put("code", u.getCode());
            UserMap.put("username", u.getUsername());
            UserMap.put("admin", u.getAdmin());
            String token = JwtUtil.genToken(UserMap);
            return Result.success(token);
        }
    }

    //获取当前用户信息
    @GetMapping("/userInfo/current")
    public Result<User> userInfoCurrent() {
        Map<String, Object> userMap = ThreadLocalUtil.get();
        int code = (int) userMap.get("code");
        User u = userService.selectUserByCode(code);
        return Result.success(u);
    }

    //获取全部用户信息
    @GetMapping("/userInfo/all")
    public Result<List<User>> userInfoAll() {
        List<User> users = userService.selectAllUser();
        return Result.success(users);
    }

    //分页查询用户信息
    @GetMapping("/userInfo/all/page")
    public Result<PageBean<User>> userInfoAllPage(Integer page, Integer size) {
        PageBean<User> users = userService.selectAllUserByPage(page, size);
        return Result.success(users);
    }

    //根据用户编号查询用户信息
    @GetMapping("/userInfo/byCode")
    public Result<User> userInfoByCode(int code) {
        User u = userService.selectUserByCode(code);
        return Result.success(u);
    }

    //根据用户名查询用户信息
    @GetMapping("/userInfo/byUsername")
    public Result<User> userInfoByUsername(String username) {
        User u = userService.selectUserByUsername(username);
        return Result.success(u);
    }

    //更新用户信息
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        //这里传过来的密码使用户输入的明文密码需要加密为MD5
        if (user.getPassword() != null)
            user.setPassword(Md5Util.getMD5String(user.getPassword()));
        userService.updateUser(user);
        return Result.success(user);
    }

    //删除用户
    // 202-用户名不存在
    @DeleteMapping("/delete")
    public Result delete(String username) {
        User u = userService.selectUserByUsername(username);
        if (u != null) {
            userService.deleteUser(u.getCode());
            return Result.success();
        } else return Result.fail(202);
    }

}