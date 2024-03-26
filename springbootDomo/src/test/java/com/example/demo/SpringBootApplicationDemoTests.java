package com.example.demo;

import ch.qos.logback.core.helpers.NOPAppender;
import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import com.example.demo.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootTest
class SpringBootApplicationDemoTests {

    private ConfigurableApplicationContext run;

    @BeforeEach
    void before(){
        //1.返回IOC容器
        run = SpringApplication.run(SpringBootDemoApplication.class);
//        ApplicationContext run = new
    }

    @Test
    void contextLoads(){
        log.info("contextLoads is running!");
    }

    //组件添加
    @Test
    void addComponent() {

        //2.查看容器里的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String name: beanDefinitionNames){
            System.out.println(name);
        }
        //3.从容器中获取组件
        Pet pet01 = run.getBean("dog-g-g-g", Pet.class);
        Pet pet02 = run.getBean("dog-g-g-g", Pet.class);
        System.out.println(pet01==pet02);

        MyConfig bean =  run.getBean(MyConfig.class);
        System.out.println(bean);

        User wangmazi01 = bean.wangmazi();
        User wangmazi02= bean.wangmazi();
        System.out.println("此王麻子是彼王麻子："+(wangmazi01 == wangmazi02));

        User wangmazi = bean.wangmazi();
        System.out.println("王麻子的宠物是虎虎：" + (wangmazi.getPet() == bean.dog()));

        //5.获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s: beanNamesForType){
            System.out.println(s);
        }

        NOPAppender bean1 = run.getBean(NOPAppender.class);
        System.out.println(bean1);
    }


    @Test
    void test2(){

        //6.测试Conditional
        boolean userExist = run.containsBean("wangmazi");
        log.info("\n----------LOG IS COMMING!------------------");
        System.out.println("王麻子"+userExist);
        boolean userExist1 = run.containsBean("dog-g-g-g");
        System.out.println("虎虎"+userExist1);
        System.out.println("dog2存在：" + run.containsBean("dog2"));
        System.out.println("userXml:"+run.containsBean("userXml"));

    }

    @Test
    void Test3(){
        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println(beanNamesForType.length);
        beanNamesForType = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println(beanNamesForType.length);

    }
}
