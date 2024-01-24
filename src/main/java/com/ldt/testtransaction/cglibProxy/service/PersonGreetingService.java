package com.ldt.testtransaction.cglibProxy.service;

import org.springframework.stereotype.Service;

@Service
public class PersonGreetingService {
     public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}
