package com.example.musicwebsite.controller;



import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.Consumer;
import com.example.musicwebsite.model.request.ConsumerRequest;
import com.example.musicwebsite.service.ConsumerService;
import com.example.musicwebsite.service.impl.ConsumerServiceImpl;
import com.example.musicwebsite.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    ConsumerServiceImpl consumerServiceimpl;


    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * 注册
     * 用户注册
     */
    @PostMapping("/user/add")
    public R addUser(@RequestBody ConsumerRequest registryRequest) {
        return consumerService.addUser(registryRequest);
    }

    /**
     *  登录
     * 登录判断
     */
    @PostMapping("/user/login/status")
    public R loginStatus(@RequestBody ConsumerRequest loginRequest, HttpSession session) {
        return consumerService.loginStatus(loginRequest, session);
    }





    /*管理端*/



}
