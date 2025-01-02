package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Register {
    private Integer code;
    private Integer doctorCode;
    private Integer userCode;
    private Date regTime;
    private Date visitTime;
    private RegisterStatus status;
    private String remark;
}
