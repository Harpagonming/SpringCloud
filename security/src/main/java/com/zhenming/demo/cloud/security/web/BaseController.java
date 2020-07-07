package com.zhenming.demo.cloud.security.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
  @RequestMapping("/base/test")
  public String test() throws InterruptedException {
    Thread.sleep(5000);
    return "Success";
  }
}
