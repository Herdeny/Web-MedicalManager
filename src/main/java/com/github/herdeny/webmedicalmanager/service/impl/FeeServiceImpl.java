package com.github.herdeny.webmedicalmanager.service.impl;

import com.github.herdeny.webmedicalmanager.mapper.FeeMapper;
import com.github.herdeny.webmedicalmanager.pojo.Fee;
import com.github.herdeny.webmedicalmanager.pojo.PayStatus;
import com.github.herdeny.webmedicalmanager.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeMapper feeMapper;

    @Override
    public void add(int userCode, String object, BigDecimal price) {
        feeMapper.insertFee(userCode, object, price);
    }

    @Override
    public void delete(int code) {
        feeMapper.deleteFee(code);
    }

    @Override
    public void update(int code, PayStatus status) {
        feeMapper.updateStatus(code, status);
    }

    @Override
    public List<Fee> getFeeUser(int userCode) {
        return feeMapper.getFeeUser(userCode);
    }

    @Override
    public BigDecimal getFeeMonth(String month) {
        return feeMapper.getMonthTotal(month);
    }

    @Override
    public List<Fee> getFeeAll() {
        return feeMapper.getFeeAll();
    }

}
