package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.RegisterStatus;

import java.util.Date;

public interface RegisterService {
    void insertRegister(int doctorCode, int userCode, Date visitTime, String remark);

    void updateRegister(int code, RegisterStatus status);

    void deleteRegister(int code);

    int countDay(String date);

    int waitDay(String date);
}
