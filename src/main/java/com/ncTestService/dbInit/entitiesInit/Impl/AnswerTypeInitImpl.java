package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.AnswerTypeInit;
import com.ncTestService.models.AnswerType;
import com.ncTestService.repositories.AnswerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerTypeInitImpl implements AnswerTypeInit {

    @Autowired
    AnswerTypeRepository answerTypeRepository;

    @Override
    public void initAnswerTypes() {

        List<AnswerType> list = new ArrayList<>();

        String[] types = {"radio", "check", "free"};

        for(String type : types) {
            list.add(new AnswerType(type));
        }

        answerTypeRepository.saveAll(list);

    }
}
