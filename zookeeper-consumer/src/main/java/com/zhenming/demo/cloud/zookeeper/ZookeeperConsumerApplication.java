package com.zhenming.demo.cloud.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZookeeperConsumerApplication {
  private static final Logger log = LoggerFactory.getLogger(ZookeeperConsumerApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperConsumerApplication.class, args);
    log.info("Program has been launched successfully...");
  }
}
