package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.TestFormatInit;
import com.ncTestService.models.TestFormat;
import com.ncTestService.repositories.TestFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestFormatInitImpl implements TestFormatInit {

    @Autowired
    TestFormatRepository testFormatRepository;

    @Override
    public void initTestFormats() {

        testFormatRepository.save(new TestFormat(10, 10, 7));

    }
}
