package com.tzword.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    //①、基本数值
    //②、可以写SpEl(Spring el表达式)：#{}
    //③、可以写 ${}：取出配置文件【properties】中的值(在运行环境变量里面的值)
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private String age;
    @Value("${person.nickName}")
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
