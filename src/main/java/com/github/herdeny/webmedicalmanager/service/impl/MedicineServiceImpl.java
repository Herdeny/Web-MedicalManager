package com.github.herdeny.webmedicalmanager.service.impl;


import com.github.herdeny.webmedicalmanager.mapper.MedicineMapper;
import com.github.herdeny.webmedicalmanager.pojo.Class;
import com.github.herdeny.webmedicalmanager.pojo.Medicine;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.service.MedicineService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public Medicine selectMedicineByCode(int code) {
        return medicineMapper.selectMedicineByCode(code);
    }

    @Override
    public List<Medicine> selectMedicineByName(String name) {
        return medicineMapper.selectMedicineByName(name);
    }

    @Override
    public List<Medicine> selectMedicineByType(Class type) {
        return medicineMapper.selectMedicineByType(type);
    }

    @Override
    public List<Medicine> selectMedicineByProducer(String producer) {
        return medicineMapper.selectMedicineByProducer(producer);
    }

    @Override
    public List<Medicine> selectAllMedicine() {
        return medicineMapper.selectAllMedicine();
    }

    @Override
    public PageBean<Medicine> selectAllMedicineByPage(int page, int size) {
        PageBean<Medicine> pageBean = new PageBean<>();
        PageHelper.startPage(page, size);
        List<Medicine> medicines = medicineMapper.selectAllMedicine();
        Page<Medicine> medicinePage = (Page<Medicine>) medicines;
        pageBean.setTotal(medicinePage.getTotal());
        pageBean.setItems(medicinePage.getResult());
        return pageBean;
    }

    @Override
    public void insertMedicine(Medicine medicine) {
        medicineMapper.insertMedicine(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        medicineMapper.updateMedicine(medicine);
    }

    @Override
    public void deleteMedicine(int code) {
        medicineMapper.deleteMedicineByCode(code);
    }
}
