package com.zhenming.demo.cloud.eureka.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
  public static final Logger log = LoggerFactory.getLogger(BaseController.class);

  @GetMapping("/base/test")
  public Object home(@RequestParam("id") String id) {
    log.info("/base/test\tparameter: id = {}", id);
    return id;
  }
}
