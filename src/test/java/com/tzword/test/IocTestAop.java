package com.tzword.test;

import com.tzword.aop.MathCalculator;
import com.tzword.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestAop {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

          //不要自己创建对象，使用Spring容器中的
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1,1)

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,0);
        applicationContext.close();
    }
}
