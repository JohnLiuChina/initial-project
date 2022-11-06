package com.learning.java8.learning.designPattern.proxy;

import com.learning.java8.service.RegisteService;
import com.learning.java8.service.impl.RegisteAppleImpl;
import com.learning.java8.service.impl.RegistePearImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;


@Slf4j
public class StaticAppleProxy implements RegisteService {

    private RegisteAppleImpl registeApple;

    public StaticAppleProxy(RegisteService appleImpl) {
        if (appleImpl.getClass() == RegisteAppleImpl.class) {
            this.registeApple = (RegisteAppleImpl) appleImpl;
        }
    }

    @Override
    public void registe(String url) {
        if (registeApple == null) {
            log.error("object to proxy is null");
            return;
        }
        registeApple.registe(url);
    }

    @Override
    public void foreach() {

    }

    @Override
    public String getJsonStr() {
        return "";
    }

}
