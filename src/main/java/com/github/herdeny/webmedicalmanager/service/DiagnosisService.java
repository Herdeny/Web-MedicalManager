package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Diagnosis;
import com.github.herdeny.webmedicalmanager.pojo.PageBean;

import java.util.List;

public interface DiagnosisService {
    void insertDiagnosis(Diagnosis diagnosis);

    void updateDiagnosis(Diagnosis diagnosis);

    void deleteDiagnosis(int code);

    Diagnosis selectDiagnosisByCode(int code);

    Diagnosis selectDiagnosisByUserCode(int userCode);

    Diagnosis selectDiagnosisByDoctorCode(int doctorCode);

    List<Diagnosis> selectAllDiagnosis();

    PageBean<Diagnosis> selectAllDiagnosisByPage(Integer pageNum, Integer pageSize);
}
