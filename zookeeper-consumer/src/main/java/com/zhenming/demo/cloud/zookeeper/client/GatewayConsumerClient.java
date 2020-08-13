package com.zhenming.demo.cloud.zookeeper.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("gateway-zookeeper")
public interface GatewayConsumerClient {
  @RequestMapping(method = RequestMethod.GET, value = "/zookeeper-producer")
  String home();
}
