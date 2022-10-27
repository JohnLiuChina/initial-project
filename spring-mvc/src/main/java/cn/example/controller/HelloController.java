package cn.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/Hello")
    public String hello(@RequestParam(value = "name", defaultValue = "defaultName") String name) {
        System.out.println("request name:" + name);
        return "redirect:index.jsp";
    }

}
