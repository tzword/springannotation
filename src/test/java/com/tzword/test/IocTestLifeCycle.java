package com.tzword.test;

import com.tzword.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestLifeCycle {
    @Test
    public void test01(){
        //创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        applicationContext.getBean("car");

        //关闭容器
        applicationContext.close();

    }
}
