package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.SpecialityInit;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpecialityInitImpl implements SpecialityInit {

    @Autowired
    SpecialityRepository specialityRepository;

    public void initSpecialities() {
        List<Speciality> list = new ArrayList<>();

        try {

            URI devURI = getClass().getResource("/spec_descriptions/DEV.txt").toURI();
            URI baURI = getClass().getResource("/spec_descriptions/BA.txt").toURI();
            URI qaURI = getClass().getResource("/spec_descriptions/QA.txt").toURI();

            list.add(new Speciality("DEV", new String(Files.readAllBytes(Paths.get(devURI)))));
            list.add(new Speciality("BA", new String(Files.readAllBytes(Paths.get(baURI)))));
            list.add(new Speciality("QA", new String(Files.readAllBytes(Paths.get(qaURI)))));

        } catch (Exception e) {
            e.printStackTrace();
        }

        specialityRepository.saveAll(list);

    }

}
