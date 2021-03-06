package com.ncTestService.services.impl;

import com.ncTestService.EmailScheduler.EmailJob;
import com.ncTestService.models.UserInfo;
import com.ncTestService.repositories.TestRepository;
import com.ncTestService.services.EmailService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private Scheduler scheduler;
    private TestRepository testRepository;

    @Autowired
    public EmailServiceImpl(Scheduler scheduler, TestRepository testRepository) {
        this.scheduler = scheduler;
        this.testRepository = testRepository;
    }

    @Override
    public void scheduleEmail(UserInfo userInfo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date testStart = dateFormat.parse(userInfo.getEnrollment().getEnrollment().getTestStart());
            Date testEnd = dateFormat.parse(userInfo.getEnrollment().getEnrollment().getTestEnd());

            if (testStart.before(new Date())) {
                logger.info("test available");
                JobDetail jobDetailStart = buildJobDetail(userInfo.getUser().getEmail(), "New test is available");
                Trigger triggerStart = buildJobTrigger(jobDetailStart, new Date());
                scheduler.scheduleJob(jobDetailStart, triggerStart);
            }

            if (userInfo.getStudentStatus().equals("TestWritten") && testEnd.after(new Date())) {
                logger.info("test passed");
                JobDetail jobDetailEnd = buildJobDetail(userInfo.getUser().getEmail(), "You have " +
                        (testRepository.findByUser(userInfo.getUser()).isPassed() ? "passed" : "failed")
                        + " the test");
                Trigger triggerEnd = buildJobTrigger(jobDetailEnd, new Date());
                scheduler.scheduleJob(jobDetailEnd, triggerEnd);
            }
        } catch (SchedulerException ex) {
            logger.error("Error scheduling email", ex);
        } catch (ParseException ex) {
            logger.error("Error parsing date", ex);
        }
    }

    @Override
    public JobDetail buildJobDetail(String email, String text) {
        JobDataMap jobDataMap = new JobDataMap();

        jobDataMap.put("email", email);
        jobDataMap.put("subject", "Test Notification");
        jobDataMap.put("body", text);

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(UUID.randomUUID().toString(), "email-jobs")
                .withDescription("Send Email Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    @Override
    public Trigger buildJobTrigger(JobDetail jobDetail, Date startAt) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(startAt)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
