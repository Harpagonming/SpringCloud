package com.zhenming.demo.cloudprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class BaseController {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/base/get")
    public String get(@RequestParam("name") String name) {
        return "Hello, " + name + ". Current time is " + sdf.format(new Date());
    }
}
