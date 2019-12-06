package com.tzword.config;

import com.tzword.bean.Person;
import com.tzword.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类 == 配置文件
@Configuration  //告诉spring这个是一个配置类
@ComponentScan(value = "com.tzword",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes ={BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[],指定扫描的时候按照扫描规则排除那些组件
//includeFilters = Filter[],指定扫描的时候包含哪些组件
//FilterType.ANNOTATION,按照注解
//FilterType.ASSIGNABLE_TYPE,按照给定的类型
//FilterType.ASPECTJ,使用ASPECTJ表达式
//FilterType.REGEX,使用正则表达式
//FilterType.CUSTOM,使用自定义规则
public class MainConfig {
    //给容器中注册一个Bean；类型为返回值的类型，id默认用方法名做为id
    @Bean(name = "aaa")
    public Person person01(){
        return new Person("lisi","20");
    }
}
