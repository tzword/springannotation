package com.tzword.config;

import com.tzword.aop.LogAspects;
import com.tzword.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP: 【动态代理】
 *      指再程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的变成模式：
 *
 * 1、导入aop(spring-aspects)
 * 2、定义一个业务逻辑（MathCalculator）,在业务逻辑运行的时候将日志进行打印（方法之前，方法运行结束，方法出现异常）
 * 3、定义一个日志切面类（logAspects）,切面类里面的方法需要动态感知MathCalculator.div运行到
 *          通知方法：
 *                  前置通知(@Before)：logStart,在目标方法(div)运行之前运行
 *                  后置通知(@After)：logEnd,在目标方法(div)运行结束之后运行
 *                  返回通知(@AfterReturning)：logReturn,在目标方法(div)正常返回之后运行
 *                  异常通知(@AfterThrowing)：logException,在目标方法(div)出现异常以后运行
 *                  环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
 * 4、给切面类的目标方法标注任何时间的运行(通知注解)
 * 5、将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6、必须告诉Spring哪个类是切面类（给切面加上一个注解，@Aspect）
 * [7]、给配置类中加入@EnableAspectJAutoProxy【开启基于注解的aop模式】
 *          在Spring中很多的@EnableXXX;
 *
 * 三步：
 *      1）、将业务逻辑组件和切面类都加入到容器中:告诉Spring哪个是切面类(@Aspect)
 *      2）、在切面上的每一个通知方法上标注通知注解，告诉Spring何时何地运行(切入点表达式)
 *      3）、开启基于注解的aop模式，@EnableAspectJAutoProxy
 *
 *  AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能】
 *      @EnableAspectJAutoProxy
 *      1.@EnableAspectJAutoProxy是什么？
 *          @Import(AspectJAutoProxyRegistrar.class)，给容器导入AspectJAutoProxyRegistrar
 *              利用AspectJAutoProxyRegistrar自定义给容器中注册bean:
 *              internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *
 *          给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *       2.AnnotationAwareAspectJAutoProxyCreator
*              ->AspectJAwareAdvisorAutoProxyCreator
*                  ->AbstractAdvisorAutoProxyCreator
*                      ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
*                          关注后置处理器(在bean初始化完成前后做事情)、自动装配BeanFactory
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
