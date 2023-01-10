package com.learning.java8.learning.designPattern.strategy;

import com.learning.java8.aspect.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Service
public class DealingContext {

    private Map<String, DealingService> serviceMap = new HashMap<>();

    @Autowired
    public void setServices(List<DealingService> services) {
        services.forEach(service -> {
            Class<? extends DealingService> aClass = service.getClass();
            DealingType annotation = aClass.getAnnotation(DealingType.class);
            if (annotation != null) {
                serviceMap.put(annotation.type(), service);
            }
        });
    }

    @Custom(info = "dealing")
    public Future<?> dealing(String type) {
        DealingService dealingService = serviceMap.get(type);
        if (dealingService == null) {
            return null;
        }
        return dealingService.dealing();
    }

    public void load(String type) {
        DealingService dealingService = serviceMap.get(type);
        if (dealingService == null) {
            return;
        }
        AbstractLoader loader = (AbstractLoader) dealingService;
        loader.allInOne();
    }

}
