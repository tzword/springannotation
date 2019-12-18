package com.tzword.test;

import com.tzword.bean.Boss;
import com.tzword.bean.Car;
import com.tzword.bean.Color;
import com.tzword.bean.Red;
import com.tzword.config.MainConfigOfAutowired;
import com.tzword.config.MainConfigOfLifeCycle;
import com.tzword.dao.BookDao;
import com.tzword.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestAutowired {
    @Test
    public void test01(){
        //创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bean = applicationContext.getBean(BookService.class);
//        System.out.println("test01:"+bean);

//        BookDao bean1 = applicationContext.getBean(BookDao.class);
//        System.out.println("test01:"+bean1);
//        Boss bean1 = applicationContext.getBean(Boss.class);
//        System.out.println(bean1);
//        Car bean2 = applicationContext.getBean(Car.class);
//        System.out.println(bean2);
//        Color bean3 = applicationContext.getBean(Color.class);
//        System.out.println(bean3);
//        Red bean4 = applicationContext.getBean(Red.class);
//        System.out.println(bean4);

        System.out.println(applicationContext);
        //关闭容器
        applicationContext.close();

    }
}
