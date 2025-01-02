package com.github.herdeny.webmedicalmanager.controller;

import com.github.herdeny.webmedicalmanager.pojo.Class;
import com.github.herdeny.webmedicalmanager.pojo.Medicine;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.pojo.Result;
import com.github.herdeny.webmedicalmanager.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/// 药品管理
@RestController
@RequestMapping("/medicine")
@Validated
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    /// 根据序号查询药品
    @GetMapping("/medicineInfo/byCode")
    public Result<Medicine> selectMedicineByCode(Integer code) {
        return Result.success(medicineService.selectMedicineByCode(code));
    }

    /// 根据药品名查询药品
    @GetMapping("/medicineInfo/byName")
    public Result<List<Medicine>> selectMedicineByName(String name) {
        return Result.success(medicineService.selectMedicineByName(name));
    }

    /// 根据药品类型查询药品
    @GetMapping("/medicineInfo/byType")
    public Result<List<Medicine>> selectMedicineByType(Class type) {
        return Result.success(medicineService.selectMedicineByType(type));
    }

    /// 根据生产厂家查询药品
    @GetMapping("/medicineInfo/byProducer")
    public Result<List<Medicine>> selectMedicineByProducer(String producer) {
        return Result.success(medicineService.selectMedicineByProducer(producer));
    }

    /// 查询所有药品
    @GetMapping("/medicineInfo/all")
    public Result<List<Medicine>> selectAllMedicine() {
        return Result.success(medicineService.selectAllMedicine());
    }

    /// 分页查询药品
    @GetMapping("/medicineInfo/all/page")
    public Result<PageBean<Medicine>> selectAllMedicineByPage(Integer page, Integer size) {
        return Result.success(medicineService.selectAllMedicineByPage(page, size));
    }

    /// 增加药品
    @PostMapping("/add")
    public void insertMedicine(Medicine medicine) {
        medicineService.insertMedicine(medicine);
    }

    /// 更新药品信息
    @PutMapping("/update")
    public void updateMedicine(Medicine medicine) {
        medicineService.updateMedicine(medicine);
    }

    /// 根据序号删除药品
    @DeleteMapping("/delete")
    public void deleteMedicine(Integer code) {
        medicineService.deleteMedicine(code);
    }
}
