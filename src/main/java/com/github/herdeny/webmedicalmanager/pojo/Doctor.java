package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

@Data
public class Doctor {
    private Integer code;
    private String name;
    private Gender gender;
    private Integer departmentCode;
    private String avatar;
    private String description;
    private String title;
    private Integer age;

}
