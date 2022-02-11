package com.proxy;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @Autowired
    private RouteAgentImpl routeAgent;

    @RequestMapping(value = "/test/**", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
    public ResponseEntity test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("proxy test...");
        return routeAgent.forward(request, response, "http://127.0.0.1:8088", "proxy", "receive");
    }

//    @RequestMapping(value = "/receive", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
//    public void receive(@RequestBody RequestParam requestParam){
//        System.out.println(requestParam);
////        try {
////            log.info("receive redirect request attribute:{}", request.getAttribute("asiainfo"));
////            InputStream inputStream = request.getInputStream();
////            log.info("receive redirect request body:{}", new String(StreamUtils.copyToByteArray(inputStream)));
////        }catch (Exception e){
////            System.out.println(e);
////        }
//    }
}
