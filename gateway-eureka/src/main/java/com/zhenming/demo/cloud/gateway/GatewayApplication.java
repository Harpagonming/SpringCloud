package com.zhenming.demo.cloud.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class GatewayApplication {
  private static final Logger log = LoggerFactory.getLogger(GatewayApplication.class);

  public static ApplicationContext context;

  public static void main(String[] args) {
    context = SpringApplication.run(GatewayApplication.class, args);
    log.info("Program has been launched successfully...");
  }
}
