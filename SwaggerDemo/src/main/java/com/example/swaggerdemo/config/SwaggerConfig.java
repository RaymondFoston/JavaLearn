package com.example.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启
                .enable(true)
                .select()
                //扫描的路劲包，设置basePackage会将包下的所有@Api标记的类中的方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerdemo"))
                //指定路径处理，PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //API标题
                .title("springboot中使用swagger2接口demo")
                //文档描述
                .description("接口说明")
                //服务条款url
                .termsOfServiceUrl("http://localhost:8080/")
                //版本号
                .version("1.0.0")
                .build();
    }
}