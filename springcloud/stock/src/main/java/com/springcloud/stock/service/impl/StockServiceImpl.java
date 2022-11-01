package com.springcloud.stock.service.impl;

import com.springcloud.stock.mapper.StockMapper;
import com.springcloud.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public void update() {
        stockMapper.update();
    }
}
