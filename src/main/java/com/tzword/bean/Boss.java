package com.tzword.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

    //构造器所用的组件，也都是从容器中获取
    //@Autowired
    public Boss(@Autowired Car car){
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    //@Autowired
    //标注在方法上，Spring容器创建对象，就会调用方法，完成赋值
    //方法使用的参数，自定义的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
