package com.github.herdeny.webmedicalmanager.service;

import com.github.herdeny.webmedicalmanager.pojo.Fee;
import com.github.herdeny.webmedicalmanager.pojo.PayStatus;

import java.math.BigDecimal;
import java.util.List;

public interface FeeService {
    void add(int userCode, String object, BigDecimal price);

    void delete(int code);

    void update(int code, PayStatus status);

    List<Fee> getFeeUser(int userCode);

    BigDecimal getFeeMonth(String month);

    List<Fee> getFeeAll();
}
