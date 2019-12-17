package com.tzword.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car ... int...");
    }

    public void destroy(){
        System.out.println("car ... destroy...");
    }
}
