package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;

import java.util.List;

public interface DoctorService {
    Doctor selectDoctorByCode(int code);

    List<Doctor> selectDoctorByName(String name);

    List<Doctor> selectDoctorByDepartmentCode(int departmentCode);

    List<Doctor> selectDoctorByDepartmentName(String departmentName);

    List<Doctor> selectAllDoctor();

    PageBean<Doctor> selectAllDoctorPage(int page, int size);

    void insertDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int code);
}
