package com.ncTestService.services;

import com.ncTestService.models.UserInfo;
import org.quartz.JobDetail;
import org.quartz.Trigger;

import java.util.Date;

public interface EmailService {
    void scheduleEmail(UserInfo userInfo);

    JobDetail buildJobDetail(String email, String text);

    Trigger buildJobTrigger(JobDetail jobDetail, Date startAt);
}
