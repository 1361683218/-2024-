package com.example.musicwebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.ConsumerMapper;
import com.example.musicwebsite.model.domain.Consumer;
import com.example.musicwebsite.model.request.ConsumerRequest;
import com.example.musicwebsite.service.ConsumerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import javax.servlet.http.HttpSession;

import java.nio.charset.StandardCharsets;



@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;


    /**
     * @description 添加新用户
     */
    @Override
    public R addUser(ConsumerRequest registryRequest) {
        //return R.warning("用户名已注册");
        //return R.error("注册失败");
        return R.success("注册成功");

    }
    /**
     * @description 用户存在判定
     */
    @Override
    public boolean existUser(String username) {
        return true;
    }
    /**
     * @description 用户登录密码判定
     */
    @Override
    public boolean verityPasswd(String username, String password) {

        return true;
    }

    @Override
    public R loginStatus(ConsumerRequest loginRequest, HttpSession session) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (this.verityPasswd(username, password)) {
            session.setAttribute("username", username);
            Consumer consumer = new Consumer();
            consumer.setUsername(username);
            return R.success("登录成功", consumerMapper.selectList(new QueryWrapper<>(consumer)));
        } else {
            return R.error("用户名或密码错误");
        }
    }


}
