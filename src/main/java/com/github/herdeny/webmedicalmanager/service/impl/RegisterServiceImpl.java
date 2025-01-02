package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.RegisterMapper;
import com.github.herdeny.webmedicalmanager.pojo.RegisterStatus;
import com.github.herdeny.webmedicalmanager.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public void insertRegister(int doctorCode, int userCode, Date visitTime, String remark) {
        registerMapper.insertRegister(doctorCode, userCode, visitTime, remark);
    }

    @Override
    public void updateRegister(int code, RegisterStatus status) {
        registerMapper.updateRegisterStatus(code, status);
    }

    @Override
    public void deleteRegister(int code) {
        registerMapper.deleteRegister(code);
    }
}
