package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

@Data
public class User {
    private Integer code;
    private String username;
    private String password;
    private String name;
    private Gender gender;
    private Integer age;
    private Integer mRecord;
    private Integer phone;
}
