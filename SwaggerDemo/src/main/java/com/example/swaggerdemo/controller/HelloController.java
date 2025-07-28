package com.example.swaggerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public String post() {
        return "post";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
