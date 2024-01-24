package com.ldt.testtransaction.testEntity.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ldt.testtransaction.person.entiry.Person;
import com.ldt.testtransaction.person.repository.PersonRepository;
import com.ldt.testtransaction.person.service.PersonService;
import com.ldt.testtransaction.testEntity.entity.TestEntity;
import com.ldt.testtransaction.testEntity.repository.TestRepository;
import com.ldt.testtransaction.testEntity.util.Util;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    TestController testController;

    @GetMapping("/get")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void get() throws Exception {
        Util.printThread();
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        Random random = new Random();
        int i = random.nextInt(100);
        String name = "no_support_ " + i;
        personRepository.insertRecode(name);
//        Thread t = new Thread(() -> {personService.addPerson();});
//        t.start();

        throw new Exception("test");
    }

    @GetMapping("/get2")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void get2() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        personRepository.insertRecode(testEntity.getName());
        Util.printObjectInfo(testEntity);
//        personService.addPerson();
        throw new Exception("test");
    }

    @GetMapping("/get3")
    @Transactional
    public void get3() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        Util.printObjectInfo(testEntity);
//        personService.addPerson();
        throw new Error("test");
//        throw new RuntimeException("test");
    }

    @GetMapping("/get4")
    @Transactional
    public void get4() throws Exception {
        personService.addPerson();
        TestEntity testEntity = new TestEntity();
        Util.printObjectInfo(testEntity);
        testRepository.save(testEntity);
//        throw new Error("test");
        throw new RuntimeException("test");
    }

//    @Async


    @GetMapping("/get5")
    @Transactional
    public void get5() throws Exception {
        personService.addPerson();
        TestEntity testEntity = new TestEntity();
        Util.printObjectInfo(testEntity);
        testRepository.save(testEntity);
        throw new Exception("test");
    }

    @GetMapping("/get6")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void get6() throws Exception {
        for(int i =0; i< 3; i++){
            testController.addPerson();
        }
        Long id = testRepository.getTranId();
        System.out.println("LongID : " + id);
        TestEntity testEntity = new TestEntity();
        Util.printObjectInfo(testEntity);
        testRepository.save(testEntity);
        throw new Exception("test");
    }

    @GetMapping("/get8")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void get8() throws Exception {
        TestEntity testEntity = new TestEntity();
        Util.printObjectInfo(testEntity);
        testRepository.save(testEntity);
        personService.addEntity();
        throw new Exception("test");
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPerson(){
        Long id = personRepository.getTranId();
        System.out.println("addPerson LongID : " + id);
        Util.printThread();
        Person testEntity = new Person();
        Util.printObjectInfo(testEntity);
        personRepository.save(testEntity);
    }
}
