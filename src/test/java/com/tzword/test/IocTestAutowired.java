package com.tzword.test;

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
        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println("test01:"+bean);

//        BookDao bean1 = applicationContext.getBean(BookDao.class);
//        System.out.println("test01:"+bean1);

        //关闭容器
        applicationContext.close();

    }
}
