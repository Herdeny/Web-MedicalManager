package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Register;
import com.github.herdeny.webmedicalmanager.pojo.RegisterStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RegisterService {
    void insertRegister(int doctorCode, int userCode, Date visitTime, String remark);

    void updateRegister(int code, RegisterStatus status);

    void deleteRegister(int code);

    int countDay(String date);

    int waitDay(String date);

    int countMonth(String date);

    List<Map<Integer, Integer>> countDepartment(String date);

    List<Register> selectRegisterByUserCode(int userCode);
}
