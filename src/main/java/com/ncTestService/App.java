package com.ncTestService;


import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class);

        try {
            Scheduler scheduler =
                    new StdSchedulerFactory().getScheduler();
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(
                        GroupMatcher.jobGroupEquals(groupName))) {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    List triggers = (List)
                            scheduler.getTriggersOfJob(jobKey);
                    System.out.println("Job : " + jobName + ", Group : "
                            + jobGroup + ", Next execution time : "
                            + triggers);
                }
            }
        } catch (Exception ex){
            System.out.println("that sucks");
        }

    }
}
