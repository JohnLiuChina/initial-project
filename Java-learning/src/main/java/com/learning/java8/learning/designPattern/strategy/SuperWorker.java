package com.learning.java8.learning.designPattern.strategy;

import com.learning.java8.utils.ExecutorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Slf4j
@Service
@DealingType(type = "super")
public class SuperWorker extends AbstractLoader implements DealingService {

    @Override
    public Future<?> dealing() {
        return ExecutorUtil.submit(() -> {
            log.info("super dealing enter");
            return UUID.randomUUID().toString();
        });
    }

    @Override
    public void load() {
        log.info("super loading");
    }

    @Override
    public void verify() {
        log.info("super verifying");
    }

    @Override
    public void prepare() {
        log.info("super preparing");
    }

    @Override
    public void analysis() {
        log.info("super analysing");
    }

    @Override
    public void init() {
        log.info("super initiating");
    }

    @Override
    public void instantiation() {
        log.info("super instantiating");
    }

    @Override
    public void uninstall() {
        log.info("super uninstalling");
    }
}
