package com.tzword.test;

import com.tzword.config.MainConfigOfAutowired;
import com.tzword.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IocTestProfile {
    @Test
    public void test01(){
        //创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        //关闭容器
        applicationContext.close();

    }
}
