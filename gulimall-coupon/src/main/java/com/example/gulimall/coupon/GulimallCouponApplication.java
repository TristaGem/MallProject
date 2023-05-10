package com.example.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos config namespace, and config separation
 *
 * public: the default namespace
 *1. we could use nacos config namespace to separate the dev, prod and test env
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.gulimall.coupon.dao")
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}

