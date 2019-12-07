package com.tzword.config;

import com.tzword.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    //默认是单例的
    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     *
     * prototype:多实例的,ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象。
     * singleton:单实例(默认值),ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取的就是直接从容器(map.get())中拿
     * request:同一次请求创建一个实例
     * session:同一个session创建一个实例
     */
    @Scope("prototype")
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("王五","25");
    }
}
