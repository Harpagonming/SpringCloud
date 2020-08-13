package com.zhenming.demo.cloud.zookeeper.web;

import com.zhenming.demo.cloud.zookeeper.client.ConsumerClient;
import com.zhenming.demo.cloud.zookeeper.client.GatewayConsumerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class BaseController {
  public static final Logger log = LoggerFactory.getLogger(BaseController.class);

  @Resource
  private ConsumerClient consumerClient;
  @Resource
  private GatewayConsumerClient gatewayConsumerClient;
  @Resource
  private LoadBalancerClient loadBalancer;
  @Resource
  private RestTemplate restTemplate;

  @GetMapping("/invoke")
  public Object invoke() {
    ServiceInstance instance = loadBalancer.choose("zookeeper-producer");
    String url = "http://" + instance.getHost() + ":" + instance.getPort();
    log.info(url);
    return restTemplate.getForEntity(url, String.class);
//    return consumerClient.home();
//    return gatewayConsumerClient.home();
  }

  @GetMapping("/test")
  public String test() {
    log.info("/test");
    return "Success";
  }
}
