package com.tzword.config;

import com.tzword.bean.Color;
import com.tzword.bean.Person;
import com.tzword.bean.Red;
import com.tzword.condition.LinuxCondition;
import com.tzword.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

//类中组件统一设置。满足当前条件，这个类中配置的所有的bean注册才能生效
@Conditional({WindowsCondition.class})
@Configuration
//导入组件，id默认是组件的全类名
@Import({Color.class, Red.class})
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
     *
     * 懒加载：单实例bean：默认在容器启动的时候创建对象；
     *         懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化
     */
//    @Scope("prototype")
    @Bean("person")
    @Lazy
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("王五","25");
    }

    /**
     * @Conditional({Conditional}):按照一定的条件进行判断，满足条件给容器注册bean
     *
     * 如果系统是windows,给容器中注册("bill")
     * 如果是linux系统给容器中注册("linus")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("bill", "62");
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus", "48");
    }

    /**
     * 给容器中注册组件：
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[只适用于自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *      ① @Import(要导入到容器的组件)；容器中就会自动注册这个组件，id默认就是全类名
     */
}
