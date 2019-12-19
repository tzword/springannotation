package com.tzword.config;

import org.springframework.context.annotation.Configuration;

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
 *
 *
 *
 *
 *
 *
 *
 */


@Configuration
public class MainConfigOfAop {


}
