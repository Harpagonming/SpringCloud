package com.zhenming.demo.cloud.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {
  private static final Logger log = LoggerFactory.getLogger(SecurityApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SecurityApplication.class, args);
    log.info("Program has been launched successfully...");
  }
}
