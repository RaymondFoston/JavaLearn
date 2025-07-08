package com.example.demo.controller;


import com.example.demo.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HelloController {

    @RequestMapping("/hello1")
    public String Hello() {
        return "index.html";
    }

    @ResponseBody
    @RequestMapping(value = "/hello2")
    public String Hello2(){
            return "Hello,World!";
        }

    @ResponseBody
    @RequestMapping("/hello3")
    public String handle(@RequestParam("name") String name){
        return "Hello,SpringBoot2!" + "你好," + name;
    }
    @Autowired
    Car car;

    @ResponseBody
    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
