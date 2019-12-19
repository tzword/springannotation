package com.tzword.test;

import com.tzword.bean.Yellow;
import com.tzword.config.MainConfigOfAutowired;
import com.tzword.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IocTestProfile {

    //1、使用命令行动态参数（运行的时候加上，在VM options:-Dspring.profiles.active=dev,那运行的就是dev环境）
    //2、代码的方式激活某种环境
    @Test
    public void test01(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置激活的环境
        applicationContext.getEnvironment().setActiveProfiles("prod");
        //3.注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        //关闭容器
        applicationContext.close();

    }
}
