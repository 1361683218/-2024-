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
 * 提供后台管理相关接口的控制器
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 验证管理员登录状态。
     *
     * @param adminRequest 包含管理员账户和密码的请求对象
     * @param session     HTTP会话对象，用于存储登录状态
     * @return 包含登录状态的响应对象
     */
    @PostMapping("/admin/login/status")
    public R loginStatus(@RequestBody AdminRequest adminRequest, HttpSession session) {
        return adminService.verityPasswd(adminRequest, session);
    }
}