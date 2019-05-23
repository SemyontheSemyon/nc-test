package com.ncTestService.dbInit;

import com.ncTestService.dbInit.entitiesInit.*;
import com.ncTestService.dbInit.entitiesInit.Impl.AnswerInitImpl;
import com.ncTestService.dbInit.entitiesInit.Impl.QuestionInitImpl;
import com.ncTestService.dbInit.entitiesInit.Impl.TestInitImpl;
import com.ncTestService.models.DBStatus;
import com.ncTestService.repositories.DBStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    DBStatusRepository dbStatusRepository;
    @Autowired
    SpecialityInit specialityInit;
    @Autowired
    CityInit cityInit;
    @Autowired
    QuestionTypeInit questionTypeInit;
    @Autowired
    RoleInit roleInit;
    @Autowired
    UserInit userInit;
    @Autowired
    EnrollmentInit enrollmentInit;
    @Autowired
    TestFormatInit testFormatInit;
    @Autowired
    ECTFInit ectfInit;
    @Autowired
    QuestionInitImpl questionInit;
    @Autowired
    AnswerInitImpl answerInit;
    @Autowired
    TestInitImpl testInit;
    private boolean done = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        boolean inited = dbStatusRepository.findAll().iterator().hasNext();


        if (!inited && !done) {
            specialityInit.initSpecialities();
            cityInit.initCities();
            questionTypeInit.initQuestionTypes();
            roleInit.initRoles();
            userInit.initUsers();
            enrollmentInit.initEnrollments();
            testFormatInit.initTestFormats();
            ectfInit.initECTF();
            questionInit.initQuestions();
            answerInit.initAnswers();
            testInit.initTests();


            dbStatusRepository.save(new DBStatus(true));
            done = true;
        }
    }

}
