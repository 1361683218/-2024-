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
import org.springframework.web.multipart.MultipartFile;


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

    @Override
    public R updateUserMsg(ConsumerRequest updateRequest) {
        return R.success("修改成功");
    }

    @Override
    public R updateUserAvator(MultipartFile avatorFile, int id) {
        return R.success("上传成功", "/User/img");
    }

    @Override
    public R updatePassword(ConsumerRequest updatePasswordRequest) {
        return R.success("密码修改成功");
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
    public R deleteUser(Integer id) {
        return R.success("删除成功");
    }

    @Override
    public R allUser() {
        return R.success(null, consumerMapper.selectList(null));
    }

    @Override
    public R userOfId(Integer id) {
        return R.success(null, id);
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

    @Override
    public R loginEmailStatus(ConsumerRequest loginRequest, HttpSession session) {
        return null;
    }

    @Override
    public Consumer findByEmail(String email) {
        return null;
    }

    @Override
    public R updatePassword01(ConsumerRequest updatePasswordRequest) {
        return null;
    }


}
