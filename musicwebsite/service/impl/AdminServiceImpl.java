package com.example.musicwebsite.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.AdminMapper;
import com.example.musicwebsite.model.domain.Admin;
import com.example.musicwebsite.model.request.AdminRequest;
import com.example.musicwebsite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public R verityPasswd(AdminRequest adminRequest, HttpSession session) {
        /**
         * @author W
         * @description 管理员登录验证
         */
        /*test,返回正确*/
        session.setAttribute("name", "W");
        return R.success("登录成功");

    }
}
