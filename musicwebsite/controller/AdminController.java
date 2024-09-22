package com.example.musicwebsite.controller;


import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.request.AdminRequest;
import com.example.musicwebsite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * 后台管理的相关事宜
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 管理员登录判断
    @PostMapping("/admin/login/status")
    public R loginStatus(@RequestBody AdminRequest adminRequest, HttpSession session) {
        return adminService.verityPasswd(adminRequest, session);
    }
}
