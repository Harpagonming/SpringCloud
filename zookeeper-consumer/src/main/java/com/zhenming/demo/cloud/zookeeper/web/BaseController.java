package com.zhenming.demo.cloud.zookeeper.web;

import com.zhenming.demo.cloud.zookeeper.client.ConsumerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaseController {
  @Resource
  private ConsumerClient client;

  @RequestMapping("/invoke")
  public Object invoke() {
    return client.home();
  }
}
