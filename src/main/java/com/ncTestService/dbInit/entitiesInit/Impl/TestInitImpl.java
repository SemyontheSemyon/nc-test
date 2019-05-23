package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.models.*;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.repositories.TestRepository;
import com.ncTestService.repositories.TestUserRepository;
import com.ncTestService.repositories.UserRepository;
import com.ncTestService.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TestInitImpl {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestUserRepository testUserRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    TestService testService;

    public void initTests() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String date = "-04-2019";

        List<User> users = (List) userRepository.findAll();
        List<Speciality> specialities = (List) specialityRepository.findAll();
        List<Test> tests = new ArrayList<>();
        List<TestUser> testUsers = new ArrayList<>();
        Random random = new Random(42);


        for (User user : users) {
            Test test = new Test();
            test.setPassed(random.nextBoolean());
            try {
                test.setTakenAt(dateFormat.parse(random.nextInt(30) + 1 + date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            test.setUser(user);

            tests.add(testRepository.save(test));
        }

        for (Test test : tests) {
            List<Question> questions = testService.generateTest(10, specialities.get(random.nextInt(specialities.size())));
            for (Question q : questions) {

                TestUser testUser = new TestUser();
                testUser.setTest(test);
                testUser.setQuestion(q);
                testUser.setAnswer("A");
                boolean b = random.nextBoolean();
                testUser.setCorrect(b);
                testUser.setStudentAnswer(b ? "A" : "B");

                testUserRepository.save(testUser);

            }

        }
    }


}
