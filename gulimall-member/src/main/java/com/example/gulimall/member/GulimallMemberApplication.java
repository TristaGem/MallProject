package com.example.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//FEIGN STEP 3
@EnableFeignClients(basePackages = "com.example.gulimall.member.feign")
@MapperScan("com.example.gulimall.member.dao")
public class  GulimallMemberApplication {

    // in order to call other service remotely
    // FEIGN STEP 1. import open-feign
    // FEIGN STEP 2. write an interface telling SpringCloud that
    //  this service needs to call remote service
    // FEIGN STEP 3. enable the remote calling function
    // FEIGN STEP 4. use the remote service endpoint in an example


    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
