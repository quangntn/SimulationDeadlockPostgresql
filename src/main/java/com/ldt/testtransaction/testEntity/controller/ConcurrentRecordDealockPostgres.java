package com.ldt.testtransaction.testEntity.controller;
/**
 * use case:
 * - thread one call method accessFirstAndLongTimeToUpdate (by debug) update recode id = 1
 * - thread two call method accessSecondAndShortTimeToUpdate update recode id = 1
 * then maybe deadlock come in
 */

import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ldt.testtransaction.person.entiry.Person;
import com.ldt.testtransaction.person.repository.PersonRepository;
import com.ldt.testtransaction.person.service.PersonService;
import com.ldt.testtransaction.testEntity.repository.TestRepository;
import com.ldt.testtransaction.testEntity.util.Util;

@RestController
@RequestMapping("/deadlock")
public class ConcurrentRecordDealockPostgres {

    @Autowired
    TestRepository testRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    TestController testController;

    @GetMapping("/thread1")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void accessFirstAndLongTimeToUpdate() throws Exception {
        Util.printThread();
        Random random = new Random();
        Optional<Person> personOpt = personRepository.findById(8);
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            int i = random.nextInt(100);
            String name = "thread1_ " + i;
            person.setName(name);
            Util.printObjectInfo(name);
            personRepository.save(person);
        }
        Util.printObjectInfo("End accessFirstAndLongTimeToUpdate");
    }

    @GetMapping("/thread2")
    @Transactional(rollbackFor = {Exception.class, Throwable.class}, isolation = Isolation.REPEATABLE_READ)
    public void accessSecondAndShortTimeToUpdate() throws Exception {
        Util.printThread();
        Random random = new Random();
        Optional<Person> personOpt = personRepository.findById(8);
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            int i = random.nextInt(100);
            String name = "thread2_ " + i;
            person.setName(name);
            personRepository.save(person);
        }
        Util.printObjectInfo("End accessSecondAndShortTimeToUpdate");
    }


    @GetMapping("/thread3")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void accessFirstAndLongTimeToUpdateNative() throws Exception {
        Util.printThread();
        Random random = new Random();
//        Optional<Person> personOpt = personRepository.findById(8);
//        if (personOpt.isPresent()) {
//            Person person = personOpt.get();
            int i = random.nextInt(100);
            String name = "thread1_ " + i;
//            person.setName(name);
            Util.printObjectInfo(name);
            personRepository.updateRecordById(name, 8);
//        }
        Util.printObjectInfo("End accessFirstAndLongTimeToUpdate");
    }

    @GetMapping("/thread4")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void accessSecondAndShortTimeToUpdateNative() throws Exception {
        Util.printThread();
        Random random = new Random();
        Optional<Person> personOpt = personRepository.findById(8);
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            int i = random.nextInt(100);
            String name = "thread2_ " + i;
            person.setName(name);
            personRepository.updateRecordById(name + "19", 19);
        }
        Util.printObjectInfo("End accessSecondAndShortTimeToUpdate");
    }

    @GetMapping("/thread5")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void updateTwoItem() throws Exception {
        Util.printThread();
        Random random = new Random();
        Optional<Person> personOpt = personRepository.findById(8);
        int i = random.nextInt(100);
        String name = "thread1_ " + i;
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            person.setName(name);
            Util.printObjectInfo(name);
            personRepository.updateRecordById(name, 8);
//            personRepository.save(person);
        }
        Util.printObjectInfo("updateRecordById");
        testRepository.updateTestEntity(name, 19);
        Util.printObjectInfo("End accessFirstAndLongTimeToUpdate");

    }

    @GetMapping("/thread6")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void accessTwoItem() throws Exception {
        Util.printThread();
        Random random = new Random();
        int i = random.nextInt(100);
        String name = "thread2_ " + i;

        testRepository.updateTestEntity(name, 19);

        Optional<Person> personOpt = personRepository.findById(8);
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            person.setName(name);
            personRepository.updateRecordById(name + "8", 8);
        }
        Util.printObjectInfo("End accessSecondAndShortTimeToUpdate");
    }
}
