package com.example.demo;

import ch.qos.logback.core.helpers.NOPAppender;
import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import com.example.demo.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

}

