package com.zhenming.demo.cloud.eureka.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
  @RequestMapping("/")
  public Object home() {
    return "Hello World!";
  }
}
