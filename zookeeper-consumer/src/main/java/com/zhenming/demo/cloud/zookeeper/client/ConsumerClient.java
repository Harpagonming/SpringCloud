package com.zhenming.demo.cloud.zookeeper.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zookeeper-producer")
public interface ConsumerClient {
  @RequestMapping(method = RequestMethod.GET, value = "/")
  String home();
}
