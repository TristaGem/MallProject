package com.example.gulimall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GulimallThirdpartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallThirdpartyApplication.class, args);
	}

}
