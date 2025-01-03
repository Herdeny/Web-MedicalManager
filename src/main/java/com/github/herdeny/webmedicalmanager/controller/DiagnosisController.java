package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.*;
import com.github.herdeny.webmedicalmanager.service.DiagnosisService;
import com.github.herdeny.webmedicalmanager.service.DoctorService;
import com.github.herdeny.webmedicalmanager.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
@Validated
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    /// 添加诊断
    ///
    /// @param diagnosis 诊断信息-必须包含doctorCode, UserCode, diaSymptom, 不需要包含diaTime,其他字段有没有都可以
    @PostMapping("/add")
    public Result add(@RequestParam Diagnosis diagnosis) {
        diagnosisService.insertDiagnosis(diagnosis);
        return Result.success();
    }

    /// 修改诊断
    ///
    /// @param diagnosis 诊断信息-必须包含code, diaSymptom, 不需要包含doctorCode, UserCode, diaTime,其他字段有没有都可以
    @PutMapping("/update")
    public Result update(@RequestParam Diagnosis diagnosis) {
        diagnosisService.updateDiagnosis(diagnosis);
        return Result.success();
    }

    /// 删除诊断
    ///
    /// @param code 诊断序号Code
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer code) {
        diagnosisService.deleteDiagnosis(code);
        return Result.success();
    }

    ///  通过序号查询诊断
    ///
    /// @param code 诊断序号Code
    @GetMapping("/diagnosisInfo/byCode")
    public Result<Diagnosis> selectDiagnosisByCode(@RequestParam Integer code) {
        Diagnosis d = diagnosisService.selectDiagnosisByCode(code);
        if (d == null) return Result.fail(204);
        return Result.success(diagnosisService.selectDiagnosisByCode(code));
    }

    /// 通过用户序号查询诊断
    ///
    /// @param userCode 用户序号Code
    @GetMapping("/diagnosisInfo/byUserCode")
    public Result<Diagnosis> selectDiagnosisByUserCode(@RequestParam Integer userCode) {
        User u = userService.selectUserByCode(userCode);
        if (u == null) return Result.fail(204);
        return Result.success(diagnosisService.selectDiagnosisByUserCode(userCode));
    }

    /// 通过医生序号查询诊断
    ///
    /// @param doctorCode 医生序号Code
    @GetMapping("/diagnosisInfo/byDoctorCode")
    public Result<Diagnosis> selectDiagnosisByDoctorCode(@RequestParam Integer doctorCode) {
        Doctor d = doctorService.selectDoctorByCode(doctorCode);
        if (d == null) return Result.fail(204);
        return Result.success(diagnosisService.selectDiagnosisByDoctorCode(doctorCode));
    }

    /// 查询所有诊断
    @GetMapping("/diagnosisInfo/all")
    public Result<List<Diagnosis>> selectAllDiagnosis() {
        return Result.success(diagnosisService.selectAllDiagnosis());
    }

    /// 分页查询所有诊断
    @GetMapping("/diagnosisInfo/all/page")
    public Result<PageBean<Diagnosis>> selectAllDiagnosisByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return Result.success(diagnosisService.selectAllDiagnosisByPage(pageNum, pageSize));
    }

}
