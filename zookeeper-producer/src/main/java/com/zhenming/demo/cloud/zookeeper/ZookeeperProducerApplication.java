package com.zhenming.demo.cloud.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperProducerApplication {
  private static final Logger log = LoggerFactory.getLogger(ZookeeperProducerApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperProducerApplication.class, args);
    log.info("Program has been launched successfully...");
  }
}
