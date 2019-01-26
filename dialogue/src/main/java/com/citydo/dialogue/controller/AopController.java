package com.citydo.dialogue.controller;

import com.citydo.dialogue.entity.AccessLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AopController {

    @GetMapping("/test")
    @AccessLimit(limit = 4,sec = 10)  //加上自定义注解即可
    public String test(HttpServletRequest request,@RequestParam(value = "username",required = false) String userName){
        return  userName;
    }
}
