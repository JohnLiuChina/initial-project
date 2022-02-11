package com.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/receive")
public class ReceiveController {
    @RequestMapping(value = "/test/**", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
//    public void receive(@RequestBody RequestParam requestParam){
    public void receive(String userCode){
        System.out.println("receive:" + userCode);
    }
}
