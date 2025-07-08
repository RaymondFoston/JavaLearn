package com.company.springmvc.cortoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 告诉springMVC这是一个处理器，可以处理请求
 * @Controller标识一个控制器，不同于其他四个注解
 */
@Controller
public class firstController {
    /**
     *
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET,params = {"a","!b","c=2","d!=4"} )
    public String hello(){
        System.out.println("Request is handling...");
        //下面返回的值经过前端控制器的驶入解析器的处理
        //会加上一个前缀prefix("/WEB-INF/page/")和后缀suffix(".jsp")
        // 路径变为：/WEB-INF/page/success.jsp
        return "success";
    }

    @RequestMapping(value = "/hello2*")
    public String hello_2(){
        System.out.println("Request2 is handling...");
        return "success";
    }

    @RequestMapping(value = "/hello3/{id}")
    public String hello_3(@PathVariable("id") String id){
        System.out.println("Request2 is handling..."+id);
        return "hello3";
    }
}
