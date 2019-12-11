package com.tzword.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值，就是到导入容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //方法不能返回null值
        return new String[]{"com.tzword.bean.Blue","com.tzword.bean.Yellow"};
    }
}
