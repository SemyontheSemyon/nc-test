package com.ncTestService.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ECTFDTO {

    private Long id;
    private String speciality;
    private String city;

    private Date appStart;
    private Date appEnd;
    private Date testStart;
    private Date testEnd;
    private Date createdAt;

    private int time;
    private int numberOfQuestions;


}
