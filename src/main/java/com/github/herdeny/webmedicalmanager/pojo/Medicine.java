package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

@Data
public class Medicine {
    private Integer code;
    private String name;
    private Class type;
    private String producer;
    private String specifications;
    private String batch;
    private Integer stock;
}
