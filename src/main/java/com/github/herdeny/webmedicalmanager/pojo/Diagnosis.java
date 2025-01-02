package com.github.herdeny.webmedicalmanager.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Diagnosis {
    private Integer code;
    private Integer doctorCode;
    private Integer userCode;
    private Integer userTemper;
    private Integer bloodPressureHigh;
    private Integer bloodPressureLow;
    private Integer heartRate;
    private Date diaTime;
    private String diaSymptom;
    private String diaDiagnosis;
    private String diaMedicine;
    private String diaAdvise;
}
