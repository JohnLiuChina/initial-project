package com.springcloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.springcloud.order.feign.ProductService;
import com.springcloud.order.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String resp = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        String feignResp = stockService.reduct();
        String productResp = productService.shopping(UUID.randomUUID().toString());
        return "ok" + feignResp + productResp;
    }

    /**
     * 只有blockHandler的时候，处理方法需要在本类中且为public&相同返回值的
     * 不仅有blockHandler还有blockHandlerClass的时候处理方法需要是public static的
     * 处理方法的入参要维持原顺序，最后接收BlockException
     * 如果使用链路类型的流控，需要在配置文件中关闭链路的收敛：spring.cloud.sentinel.web-context-unify: false
     *
     * @return
     */
    @GetMapping("/detail")
    @SentinelResource(value = "detail", blockHandler = "detailFlowHandle")
    public String detail() {
        return "ok!";
    }

    public String detailFlowHandle(BlockException ex) {
        return "refused by flow handler";
    }

    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("detail");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 2.
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
