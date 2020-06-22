package com.zhenming.demo.cloud.zookeeper.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class BaseController {
  @Resource
  private LoadBalancerClient loadBalancer;
  @Resource
  private RestTemplate restTemplate;

  @RequestMapping("/invoke")
  public Object invoke() {
    ServiceInstance instance = loadBalancer.choose("gateway");
    return restTemplate.getForEntity("http://" + instance.getHost() + ":" + instance.getPort() + "/zookeeper-producer/", String.class);
  }
}
