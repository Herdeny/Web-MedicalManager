package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.DiagnosisMapper;
import com.github.herdeny.webmedicalmanager.pojo.Diagnosis;
import com.github.herdeny.webmedicalmanager.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Override
    public void insertDiagnosis(Diagnosis diagnosis) {
        diagnosisMapper.insertDiagnosis(diagnosis);
    }

    @Override
    public void updateDiagnosis(Diagnosis diagnosis) {
        diagnosisMapper.updateDiagnosis(diagnosis);
    }

    @Override
    public void deleteDiagnosis(int code) {
        diagnosisMapper.deleteDiagnosisByCode(code);
    }

    @Override
    public Diagnosis selectDiagnosisByCode(int code) {
        return diagnosisMapper.selectDiagnosisByCode(code);
    }

    @Override
    public Diagnosis selectDiagnosisByUserCode(int userCode) {
        return diagnosisMapper.selectDiagnosisByUserCode(userCode);
    }

    @Override
    public Diagnosis selectDiagnosisByDoctorCode(int doctorCode) {
        return diagnosisMapper.selectDiagnosisByDoctorCode(doctorCode);
    }
}