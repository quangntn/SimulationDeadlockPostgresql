package com.ldt.testtransaction.testEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ldt.testtransaction.testEntity.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT txid_current()")
    Long getTranId();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update dx20_agent.test_entity set name = :name where id = :id ")
    void updateTestEntity(String name, Integer id);

    @Modifying
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Query(nativeQuery = true, value = "insert into dx20_agent.test_entity(name) values(:name) ")
    void insertRecode(String name);

}