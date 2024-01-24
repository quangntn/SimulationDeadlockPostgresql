package com.ldt.testtransaction.person.entiry;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public static String[] names = new String[]{"Huong", "Truong", "Cuong", "Hieu", "MInh", "Khoa"};

    public Person() {
        Random random = new Random();
        int i = random.nextInt(5);
        this.name = names[i];
    }

    @Override
    public String toString() {
        return "TestEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}