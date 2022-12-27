package com.springcloud.order.service.impl;

import com.springcloud.order.feign.StockService;
import com.springcloud.order.mapper.OrderMapper;
import com.springcloud.order.service.OrderService;
//import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockService stockService;

    @Trace
    @Override
//    @Transactional // 解决不了分布式事务问题
//    @GlobalTransactional
    public void insert() {
        orderMapper.insert();
        String feignResp = stockService.reduct();
        System.out.println(feignResp);
    }

    @Tags({
        @Tag(key = "paramTest", value = "returnedObj"),
        @Tag(key = "param", value = "arg[0]")
    })
    @Trace
    @Override
    public String paramTest(String str) {
        return str;
    }
}
