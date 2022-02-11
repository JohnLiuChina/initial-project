package com.learning.java8.utils.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class InstanceLock {

    private static Lock myLock = new ReentrantLock();

    public static Map<String, ReentrantLock> cacheMap = new ConcurrentHashMap<>();

    public static void lock(String instanceUid) {

        ReentrantLock instanceLock = cacheMap.get(instanceUid);
        if (instanceLock == null) {

            try {

                log.info("实例：{}锁不存在，初始化锁", instanceUid);
                myLock.lock();
                instanceLock = cacheMap.get(instanceUid);
                if (instanceLock == null) {

                    log.info(Thread.currentThread().getName() + "拿到创建锁的锁", instanceUid);
                    cacheMap.put(instanceUid, new ReentrantLock(true));
                    instanceLock = cacheMap.get(instanceUid);

                }

            } catch (Exception e) {
                log.error("" + e);
            } finally {
                myLock.unlock();
            }

        }
        if (instanceLock != null) {

            if (instanceLock.tryLock()) {

                log.info("线程" + Thread.currentThread().getName() + "获取到实例" + instanceUid + "的锁");

            } else {
                try {

                    log.info("线程" + Thread.currentThread().getName() + "未获取到实例" + instanceUid + "的锁，等待");
                    Thread.sleep(100);
                    lock(instanceUid);

                } catch (InterruptedException e) {
                    log.error("" + e);
                }
            }

        } else {
            lock(instanceUid);
        }

    }

    public static void unlock(String instanceUid) {

        try {

            ReentrantLock instanceLock = cacheMap.get(instanceUid);
            if (instanceLock == null) {
                log.error("实例：{}锁异常消失", instanceUid);
                return;
            }
            log.info("线程" + Thread.currentThread().getName() + "准备释放实例：{}锁", instanceUid);
            instanceLock.unlock();


        } catch (Exception e) {
            log.error("" + e);
        }

    }

}