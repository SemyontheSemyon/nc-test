package com.ncTestService.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ECTFDTO {

    private Long id;
    private String speciality;
    private String city;

    private String appStart;
    private String appEnd;
    private String testStart;
    private String testEnd;
    private String createdAt;

    private int time;
    private int numberOfQuestions;
    private int threshold;


}
