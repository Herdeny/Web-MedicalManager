package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Class;
import com.github.herdeny.webmedicalmanager.pojo.Medicine;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;

import java.util.List;

public interface MedicineService {
    Medicine selectMedicineByCode(int code);

    List<Medicine> selectMedicineByName(String name);

    List<Medicine> selectMedicineByType(Class type);

    List<Medicine> selectMedicineByProducer(String producer);

    List<Medicine> selectAllMedicine();

    PageBean<Medicine> selectAllMedicineByPage(int page, int size);

    void insertMedicine(Medicine medicine);

    void updateMedicine(Medicine medicine);

    void deleteMedicine(int code);

}