package com.tzword.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * profile:
 *      Spring为我们提供可以根据当前环境，动态的激活和切换一系列组件的功能
 *      开发环境、测试环境、生产环境
 *      数据源（/A）（/B）（/C）
 */
@Configuration
@PropertySource("classpath:/dbconfig.properties")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    private StringValueResolver resolver;

    private String driverClass;

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        driverClass = resolver.resolveStringValue("${db.driverClass}");
    }

    @Value("${db.user}")
    private String user;

    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc://localhost:3306/test1");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc://localhost:3306/test2");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc://localhost:3306/test3");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

}
