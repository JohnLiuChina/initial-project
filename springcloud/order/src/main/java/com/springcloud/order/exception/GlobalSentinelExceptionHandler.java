package com.springcloud.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sentinel全局异常处理、粒度较大且不会影响受@SentinelResource控制的资源
 */
@Component
public class GlobalSentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String result = "";
        if (e instanceof FlowException) {
            result = "接口限流";
        } else if (e instanceof DegradeException) {
            result = "服务降级";
        } else if (e instanceof ParamFlowException) {
            result = "热点参数限流";
        } else if (e instanceof SystemBlockException) {
            result = "触发系统保护规则";
        } else if (e instanceof AuthorityException) {
            result = "授权规则不通过";
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), result);
    }
}
