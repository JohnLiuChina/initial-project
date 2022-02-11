package com.learning.java8.test;

import com.learning.java8.utils.lock.InstanceLock;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstanceLockTest {

    private static final String instanceA = "instanceA";
    private static int workedTimes = 0;

    public static void main(String[] args) {

        try {

            Thread lockTestA = new Thread(() -> doSth(instanceA));
            Thread lockTestB = new Thread(() -> doSth(instanceA));
            Thread lockTestC = new Thread(() -> doSth(instanceA));
            Thread lockTestD = new Thread(() -> doSth(instanceA));

            lockTestA.start();
            lockTestB.start();
            lockTestC.start();
            lockTestD.start();

        }catch (Exception e){
            log.error(Thread.currentThread().getName() + e);
        }

    }

    private static void doSth(String instanceUid){

        InstanceLock.lock(instanceUid);
        log.info("线程" + Thread.currentThread().getName() + "锁定实例" + instanceUid);
        log.info("线程" + Thread.currentThread().getName() + "做了一些事情");
        InstanceLock.unlock(instanceUid);
        workedTimes++;
        System.out.println(workedTimes);

    }

}
