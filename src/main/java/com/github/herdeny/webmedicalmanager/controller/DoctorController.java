package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.pojo.Result;
import com.github.herdeny.webmedicalmanager.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //通过医生序号查询医生信息
    @GetMapping("/doctorInfo/byCode")
    public Result<Doctor> doctorInfoByCode(Integer doctorCode) {
        return Result.success(doctorService.selectDoctorByCode(doctorCode));
    }

    //通过医生名字查询医生信息（模糊查询 %name%）
    @GetMapping("/doctorInfo/byName")
    public Result<List<Doctor>> doctorInfoByName(String doctorName) {
        return Result.success(doctorService.selectDoctorByName(doctorName));
    }

    //通过医生科室号查询医生信息
    @GetMapping("/doctorInfo/byDepartCode")
    public Result<List<Doctor>> doctorInfoByDepartmentCode(Integer departmentCode) {
        return Result.success(doctorService.selectDoctorByDepartmentCode(departmentCode));
    }

    //通过医生科室名字查询医生信息
    @GetMapping("/doctorInfo/byDepartName")
    public Result<List<Doctor>> doctorInfoByDepartmentName(String departmentName) {
        return Result.success(doctorService.selectDoctorByDepartmentName(departmentName));
    }

    //获取全部医生信息
    @GetMapping("/doctorInfo/all")
    public Result<List<Doctor>> doctorInfoAll() {
        return Result.success(doctorService.selectAllDoctor());
    }

    //获取医生信息分页
    @GetMapping("/doctorInfo/all/page")
    public Result<PageBean<Doctor>> doctorInfoAllPage(Integer page, Integer size) {
        return Result.success(doctorService.selectAllDoctorPage(page, size));
    }

}
