package com.tzword.condition;

import com.tzword.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata:当前类的注解信息
     * @param registry：BeanDefinition注册类
     *                把所有需要添加到容器中的bean:BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b1 = registry.containsBeanDefinition("com.tzword.bean.Yellow");
        boolean b2 = registry.containsBeanDefinition("com.tzword.bean.Blue");
        if (b1 && b2){
            //指定bean定义：（Bean的类型，Bean）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
