package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.Fee;
import com.github.herdeny.webmedicalmanager.pojo.PayStatus;
import com.github.herdeny.webmedicalmanager.pojo.Result;
import com.github.herdeny.webmedicalmanager.pojo.User;
import com.github.herdeny.webmedicalmanager.service.FeeService;
import com.github.herdeny.webmedicalmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/// 费用账单管理
@RestController
@RequestMapping("/fee")
@Validated
public class FeeController {
    @Autowired
    private FeeService feeService;
    @Autowired
    private UserService userService;

    /// 增加费用账单
    @PostMapping("/add")
    public Result add(@RequestParam Integer userCode, @RequestParam String object, @RequestParam BigDecimal price) {
        User user = userService.selectUserByCode(userCode);
        if (user == null) {
            return Result.fail(202);
        }
        feeService.add(userCode, object, price);
        return Result.success();
    }

    /// 通过序号删除费用账单
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer code) {
        feeService.delete(code);
        return Result.success();
    }

    /// 修改支付状态
    @PostMapping("/update")
    public Result update(@RequestParam Integer code, @RequestParam PayStatus status) {
        feeService.update(code, status);
        return Result.success();
    }

    /// 获取某用户的全部费用账单
    @GetMapping("/all/user")
    public Result<List<Fee>> getFeeAll(@RequestParam Integer userCode) {
        return Result.success(feeService.getFeeUser(userCode));
    }

    /// 获取全部费用账单
    @GetMapping("/all/total")
    public Result<List<Fee>> getFeeAll() {
        return Result.success(feeService.getFeeAll());
    }

    /// 获取月总费用
    /// @param month 月份,格式为"yyyy-MM",如"2025-01"，不填为当前月
    @GetMapping("/count/month")
    public Result<BigDecimal> getFeeMonth(@RequestParam(required = false) String month) {
        if (month == null) {
            month = new SimpleDateFormat("yyyy-MM").format(new Date());
        }
        return Result.success(feeService.getFeeMonth(month));
    }
}
