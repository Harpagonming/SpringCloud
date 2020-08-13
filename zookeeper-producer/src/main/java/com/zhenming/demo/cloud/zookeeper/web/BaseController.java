package com.zhenming.demo.cloud.zookeeper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class BaseController {
    public static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public Object home() {
        log.info(">>>>>>>>>>>>>>>>>>>> 调用 <<<<<<<<<<<<<<<<<<<<");
        String result = restTemplate.getForEntity("http://127.0.0.1:8680/test", String.class).getBody();
        log.info(result);
        return "Hello World!";
    }
}
