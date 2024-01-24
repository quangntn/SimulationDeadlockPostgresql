package com.ldt.testtransaction.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ldt.testtransaction.person.entiry.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(nativeQuery = true, value = "SELECT txid_current()")
    Long getTranId();

    @Modifying
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Query(nativeQuery = true, value = "insert into dx20_agent.person(name) values(:name) ")
    void insertRecode(String name);

    @Modifying
    @Transactional()
    @Query(nativeQuery = true, value = "update person set name = :name where id = :id ")
    void updateRecordById(String name, Integer id);
}