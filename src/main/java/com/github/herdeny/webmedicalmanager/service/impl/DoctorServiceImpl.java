package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.DoctorMapper;
import com.github.herdeny.webmedicalmanager.pojo.Doctor;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;
import com.github.herdeny.webmedicalmanager.pojo.User;
import com.github.herdeny.webmedicalmanager.service.DoctorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public Doctor selectDoctorByCode(int code) {
        return doctorMapper.selectDoctorByCode(code);
    }

    @Override
    public List<Doctor> selectDoctorByName(String name) {
        return doctorMapper.selectDoctorByName(name);
    }

    @Override
    public List<Doctor> selectDoctorByDepartmentCode(int departmentCode) {
        return doctorMapper.selectDoctorByDepartmentCode(departmentCode);
    }

    @Override
    public List<Doctor> selectDoctorByDepartmentName(String departmentName) {
        return doctorMapper.selectDoctorByDepartmentName(departmentName);
    }

    @Override
    public List<Doctor> selectAllDoctor() {
        return doctorMapper.selectAllDoctor();
    }

    @Override
    public PageBean<Doctor> selectAllDoctorPage(int page, int size) {
        PageBean<Doctor> pageBean = new PageBean<>();
        PageHelper.startPage(page, size);
        List<Doctor> doctors = doctorMapper.selectAllDoctor();
        Page<Doctor> doctorPage = (Page<Doctor>) doctors;
        pageBean.setTotal(doctorPage.getTotal());
        pageBean.setItems(doctorPage.getResult());
        return pageBean;
    }

    @Override
    public void insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorMapper.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int code) {
        doctorMapper.deleteDoctorByCode(code);

    }
}
