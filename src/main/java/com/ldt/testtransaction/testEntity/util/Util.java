package com.ldt.testtransaction.testEntity.util;

public class Util {

    public static void printObjectInfo(Object testEntity){
        System.out.println(testEntity);
    }

    public static void printThread(){
        System.out.println("thread " + Thread.currentThread().getId() + " name: " + Thread.currentThread().getName());
    }

//    public static void printThread(){
//        System.out.println("thread " + Thread.currentThread().getId() + " name: " + Thread.currentThread().getName() + "-");
//    }
}
