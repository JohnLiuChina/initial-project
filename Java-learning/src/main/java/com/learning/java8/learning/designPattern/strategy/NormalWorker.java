package com.learning.java8.learning.designPattern.strategy;

import com.learning.java8.aspect.Custom;
import com.learning.java8.utils.ExecutorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Slf4j
@Service
@DealingType(type = "normal")
public class NormalWorker extends AbstractLoader implements DealingService {

    @Custom(info = "normal")
    @Override
    public Future<?> dealing() {
        return ExecutorUtil.submit(() -> {
            log.info("normal dealing enter");
            return UUID.randomUUID().toString();
        });
    }

    @Custom(info = "allInOne")
    @Override
    public void allInOne() {
        super.allInOne();
    }

    @Override
    public void load() {
        log.info("normal loading");
    }

    @Override
    public void verify() {
        log.info("normal verifying");
    }

    @Override
    public void prepare() {
        log.info("normal preparing");
    }

    @Override
    public void analysis() {
        log.info("normal analysing");
    }

    @Override
    public void init() {
        log.info("normal initiating");
    }

    @Override
    public void instantiation() {
        log.info("normal instantiating");
    }

    @Override
    public void uninstall() {
        log.info("normal uninstalling");
    }

}
