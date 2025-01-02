package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Fee {
    private Integer code;
    private Integer userCode;
    private Date time;
    private String object;
    private Integer price;
    private PayStatus status;
}
