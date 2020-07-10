package com.zhenming.demo.cloud.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProducerApplication {
  private static final Logger log = LoggerFactory.getLogger(EurekaProducerApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(EurekaProducerApplication.class, args);
    log.info("Program has been launched successfully...");
  }
}
