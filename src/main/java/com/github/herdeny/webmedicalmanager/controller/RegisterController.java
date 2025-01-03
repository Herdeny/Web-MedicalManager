package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.*;
import com.github.herdeny.webmedicalmanager.service.DoctorService;
import com.github.herdeny.webmedicalmanager.service.RegisterService;
import com.github.herdeny.webmedicalmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /// 统计日挂号人数
    ///
    /// @param date 日期-格式为yyyy-MM-dd，如2021-01-01，不传默认为当天
    @GetMapping("/count/day")
    public Result<Integer> countDay(@RequestParam(required = false) String date) {
        if (date == null) {
            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return Result.success(registerService.countDay(date));
    }

    ///  统计月挂号人数
    ///
    /// @param date 日期-格式为yyyy-MM，如2021-01，不传默认为当月
    @GetMapping("/count/month")
    public Result<Integer> countMonth(@RequestParam(required = false) String date) {
        if (date == null) {
            date = new SimpleDateFormat("yyyy-MM").format(new Date());
        }
        return Result.success(registerService.countMonth(date));
    }

    /// 日科室就诊分布
    /// 返回科室序号及对应人数
    ///
    /// @param date 日期-格式为yyyy-MM-dd，如2021-01-01，不传默认为当天
    @GetMapping("/count/department")
    public Result<List<Map<Integer, Integer>>> department(@RequestParam(required = false) String date) {
        if (date == null) {
            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return Result.success(registerService.countDepartment(date));
    }


    /// 统计日平均等待时间
    /// 以时间为单位
    ///
    /// @param date 日期-格式为yyyy-MM-dd，如2021-01-01，不传默认为当天
    @GetMapping("/wait/day")
    public Result<Integer> waitDay(@RequestParam(required = false) String date) {
        if (date == null) {
            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return Result.success(registerService.waitDay(date));
    }


}
