package com.ldt.testtransaction.testEntity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ldt.testtransaction.testEntity.service.MyService;

@Service
public class TestService {

    @Autowired
    MyService myService;

    public void test(){
        myService.test();
    }
}
