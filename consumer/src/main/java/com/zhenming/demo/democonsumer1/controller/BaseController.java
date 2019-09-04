package com.zhenming.demo.democonsumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BaseController {
    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/base/get")
    public String get(@RequestParam("name") String name) {
        ServiceInstance instance = client.choose("demo-provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/base/get?name=" + name;
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
