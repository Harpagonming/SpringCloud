package com.zhenming.demo.cloud.zookeeper.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaseController {
  @Resource
  private LoadBalancerClient loadBalancer;

  @Resource
  private DiscoveryClient discoveryClient;

  @RequestMapping("/discovery")
  public Object discovery() {
    ServiceInstance instance = loadBalancer.choose("zookeeper-producer");
    return loadBalancer.choose("zookeeper-producer");
  }

  @RequestMapping("/all")
  public Object all() {
    return discoveryClient.getServices();
  }
}
