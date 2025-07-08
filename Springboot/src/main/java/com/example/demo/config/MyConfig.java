package com.example.demo.config;

import ch.qos.logback.core.helpers.NOPAppender;
import com.example.demo.bean.Car;
import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.@Configuration
 * (1)@Configuration(proxyBeanMethods = false) :com.example.demo.config.MyConfig@2940fc4f
 * (2)@Configuration : com.example.demo.config.MyConfig$$EnhancerBySpringCGLIB$$78eb1f93@7a9aa138
 * 2.Import
 *
 */


@Import({User.class, NOPAppender.class})
@Configuration(proxyBeanMethods = true)//配置文件,default为true
@ImportResource("classpath:beans.xml")  //导入spring的配置文件
@EnableConfigurationProperties(Car.class)//作用：1.开启属性配置绑定功能；2.把car这个组件自动注入到容器中
public class MyConfig {

    public static Integer count =1;

    public static Integer countJ = 1;

    @Bean(name = "dog-g-g-g")
    public Pet dog(){
        return new Pet("虎虎",11.1);
    }

    @ConditionalOnBean(name= "dog-g-g")
    @Bean
    public Pet dog2(){

        System.out.println("这是第"+countJ+"次调用=======");
        countJ++;
        return new Pet("虎虎",12.2);
    }


    @ConditionalOnBean(name = "dog-g-g-g")  //条件装配
    @Bean
    public User wangmazi(){
        User wangmazi = new User("王麻子", 18);
        wangmazi.setPet(dog());
//        System.out.println("===这里是王麻子========");
        System.out.println("这是第"+count+"次调用");
        count++;
        return wangmazi;
    }
}
