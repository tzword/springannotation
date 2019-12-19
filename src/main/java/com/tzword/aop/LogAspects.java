package com.tzword.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @Aspect,告诉Spring当前是一个切面类
 */
@Aspect
public class LogAspects {
    //抽取公用的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.tzword.aop.MathCalculator.div(int,int))")
    public void pointCut(){

    }

    //@Before在目标方法之前切入，切入点(指定在哪个方法切入)
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //方法名
        String name = joinPoint.getSignature().getName();
        //参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println(name + "...@Before...参数列表："+ Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        //方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "...@After...");
    }

    //JoinPoint一定要出现在参数列表的第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        //方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "...@AfterReturning...返回值"+ result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        //方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "...@AfterReturning...异常信息：{"+exception+"}");
    }
}
