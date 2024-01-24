package com.ldt.testtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@SpringBootApplication
public class TestTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTransactionApplication.class, args);
    }

}
