package com.company.springmvc.cortoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * springMVC如何获取请求带来的信息
 */

@Controller
public class ThirdController {
    @RequestMapping(value = "request")
    public String request_1(@RequestParam(value = "user",required = false,defaultValue = "nothing") String username,
                            @RequestHeader(value="User-Agent_",required = false) String userAgent,
                            @CookieValue(value = "JSESSIONID_",required = false)String jId
    ){
        System.out.println("Hello, "+username);
        System.out.println("Hi, "+ userAgent);
        System.out.println("This is "+jId);
        return "success";
    }

}
