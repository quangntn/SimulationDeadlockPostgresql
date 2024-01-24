package com.ldt.testtransaction.testEntity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ldt.testtransaction.testEntity.entity.TestEntity;
import com.ldt.testtransaction.testEntity.repository.TestRepository;

@Service
public class MyService {

    @Autowired
    private TestRepository testRepository;

    public void test() {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Error("test");
    }
}
