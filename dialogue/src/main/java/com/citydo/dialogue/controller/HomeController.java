package com.citydo.dialogue.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class HomeController {

    // 这里的1表示每秒允许处理的量为1个
    private RateLimiter limiter = RateLimiter.create(1.0);

    @GetMapping("/test/{name}")
    public String Test(@PathVariable("name") String name){
        // 请求RateLimiter, 超过permits会被阻塞
        final double acquire = limiter.acquire();
        System.out.println("--------"+acquire);
        //判断double是否为空或者为0
        if(acquire>=(-1e-6)&&acquire<=(1e-6)){
            return name;
        }else{
            return "操作太频繁";

        }
    }

}
