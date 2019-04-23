package com.ncTestService.dbInit;

import com.ncTestService.dbInit.entitiesInit.*;
import com.ncTestService.models.DBStatus;
import com.ncTestService.repositories.DBStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements ApplicationListener<ContextRefreshedEvent> {

    private boolean done = false;

    @Autowired
    DBStatusRepository dbStatusRepository;

    @Autowired
    SpecialityInit specialityInit;

    @Autowired
    CityInit cityInit;

    @Autowired
    AnswerTypeInit answerTypeInit;

    @Autowired
    RoleInit roleInit;

    @Autowired
    UserInit userInit;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        boolean inited = dbStatusRepository.findAll().iterator().hasNext();



        if(!inited && !done) {
            specialityInit.initSpecialities();
            cityInit.initCities();
            answerTypeInit.initAnswerTypes();
            roleInit.initRoles();
            userInit.initUsers();

            dbStatusRepository.save(new DBStatus(true));
            done = true;
        }
    }

}
