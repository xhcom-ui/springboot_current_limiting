package com.citydo.dialogue.controller;

import com.citydo.dialogue.entity.RateLimitAspect;
import com.citydo.dialogue.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类描述：RateLimit限流测试（基于注解+AOP）
 */
@Controller
public class TestController {

    @ResponseBody
    @RateLimitAspect
    @RequestMapping("/test")
    public String test() {
        return ResultUtil.success(100, "success").toString();
    }

}