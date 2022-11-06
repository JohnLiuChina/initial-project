package com.example.config;

import com.example.config.framework.definition.definition.MyBeanDefinition;
import com.example.config.framework.selector.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.example")
@Configuration
@PropertySource("classpath:db.properties")
/**
 * @Import用法：
 * 导入其他配置类
 * 导入类至IOC容器中
 * 导入ImportSelector自定义实现类，一次注册多个Bean
 * 导入ImportBeanDefinitionRegistrar自定义实现类，可以注册多个Bean定义
 */
@Import({MyImportSelector.class, MyBeanDefinition.class})
public class IocCongfig {

}
