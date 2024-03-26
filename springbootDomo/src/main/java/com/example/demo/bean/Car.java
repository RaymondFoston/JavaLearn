package com.example.demo.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//在MyConfig中开启：@EnableConfigurationProperties(Car.class)；或者使用@Component
//@Component  //只有在容器中组件，才能拥有SpringBoot提供的强大功能
@ConfigurationProperties(prefix = "mycar")
@Data@ToString
public class Car {
    private String brand;
    private Integer price;
}
