package com.zhenming.demo.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigServer {
  private static final Logger log = LoggerFactory.getLogger(ConfigServer.class);

  public static void main(String[] args) {
    SpringApplication.run(ConfigServer.class, args);
    log.info("Program has been launched successfully...");
  }
}
