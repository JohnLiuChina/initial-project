package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * 使用@Valule进行属性的依赖注入
     * 还可以使用${}获取外部值，使用#{}解析el表达式
     */
    @Value("${mysql.name}")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
