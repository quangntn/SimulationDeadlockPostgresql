package com.ldt.testtransaction.person.service;

import static com.ldt.testtransaction.testEntity.util.Util.printObjectInfo;
import static com.ldt.testtransaction.testEntity.util.Util.printThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ldt.testtransaction.testEntity.entity.TestEntity;
import com.ldt.testtransaction.testEntity.repository.TestRepository;
import com.ldt.testtransaction.person.entiry.Person;
import com.ldt.testtransaction.person.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    @Autowired
    TestRepository testRepository;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addPerson() {
        printThread();
        Person testEntity = new Person();
        printObjectInfo(testEntity);
        personRepository.save(testEntity);
//        personRepository.insertRecode(testEntity.getName());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addEntity() {
        Long id = testRepository.getTranId();
        System.out.println("addPerson NOT_SUPPORTED LongID : " + id);
        printThread();
        TestEntity testEntity = new TestEntity("Quang123");
        printObjectInfo(testEntity);
        testRepository.save(testEntity);
    }
}
