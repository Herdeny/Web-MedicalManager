package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class User {
    private Integer code;
    private String username;
    private String password;
    private String name;
    private Gender gender;
    private Integer age;
    private Integer mRecord;
    private BigInteger phone;
    private boolean admin;
    private Date regTime;
}
