package com.springcloud.order.service.impl;

import com.springcloud.order.feign.StockService;
import com.springcloud.order.mapper.OrderMapper;
import com.springcloud.order.service.OrderService;
//import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    @Transactional // 解决不了分布式事务问题
//    @GlobalTransactional
    public void insert() {
        orderMapper.insert();
        String feignResp = stockService.reduct();
        System.out.println(feignResp);
    }
}
