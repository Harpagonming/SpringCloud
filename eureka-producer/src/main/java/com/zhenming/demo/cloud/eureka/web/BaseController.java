package com.zhenming.demo.cloud.eureka.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {
  @GetMapping("/base/test")
  public Object home(HttpServletRequest request, @RequestParam("id") String id) {
//    Enumeration<String> enumeration = request.getHeaderNames();
//    while (enumeration.hasMoreElements()){
//      System.out.println(enumeration.nextElement());
//    }
    System.out.println(id);
    return id;
  }
}
