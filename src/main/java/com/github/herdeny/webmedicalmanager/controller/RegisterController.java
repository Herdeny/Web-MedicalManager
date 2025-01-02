package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.*;
import com.github.herdeny.webmedicalmanager.service.DoctorService;
import com.github.herdeny.webmedicalmanager.service.RegisterService;
import com.github.herdeny.webmedicalmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/// 挂号管理
@RestController
@RequestMapping("/register")
@Validated
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;

    /// 添加挂号信息
    @PostMapping("/add")
    public Result add(@RequestParam Integer doctorCode, @RequestParam Integer UserCode, @RequestParam Date visitTime, @RequestParam(required = false) String remark) {
        Doctor doctor = doctorService.selectDoctorByCode(doctorCode);
        User user = userService.selectUserByCode(UserCode);
        if (doctor != null && user != null) {
            registerService.insertRegister(doctorCode, UserCode, visitTime, remark);
        } else {
            return Result.fail(202);
        }
        return Result.success();
    }

    /// 修改挂号状态
    @PutMapping("/update")
    public Result update(@RequestParam Integer code, RegisterStatus status) {
        registerService.updateRegister(code, status);
        return Result.success();
    }

    /// 通过序号删除挂号信息
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer code) {
        registerService.deleteRegister(code);
        return Result.success();
    }
}