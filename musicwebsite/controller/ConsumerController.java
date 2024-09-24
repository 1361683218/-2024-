package com.example.musicwebsite.controller;

// 引入相关的类
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.Consumer;
import com.example.musicwebsite.model.domain.ResetPasswordRequest;
import com.example.musicwebsite.model.request.ConsumerRequest;
import com.example.musicwebsite.service.ConsumerService;
import com.example.musicwebsite.service.impl.ConsumerServiceImpl;
import com.example.musicwebsite.service.impl.SimpleOrderManager;
import com.example.musicwebsite.utils.RandomUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

// 消费者控制器，用于处理与用户相关的操作
@RestController
public class ConsumerController {

    // 自动注入服务
    @Autowired
    private ConsumerService consumerService;

    // 自动注入消费者服务实现
    @Autowired
    ConsumerServiceImpl consumerServiceimpl;

    // 自动注入订单管理器
    @Autowired
    private SimpleOrderManager simpleOrderManager;

    // 自动注入Redis模板
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 注册用户
     * 前台页面调用
     * @param registryRequest 注册请求参数
     * @return 返回注册结果
     */
    @PostMapping("/user/add")
    public R addUser(@RequestBody ConsumerRequest registryRequest) {
        return consumerService.addUser(registryRequest);
    }

    /**
     * 用户登录状态检查
     * 前台页面调用
     * @param loginRequest 登录请求参数
     * @param session HTTP会话
     * @return 返回登录状态
     */
    @PostMapping("/user/login/status")
    public R loginStatus(@RequestBody ConsumerRequest loginRequest, HttpSession session) {
        return consumerService.loginStatus(loginRequest, session);
    }

    /**
     * 邮箱登录状态检查
     * @param loginRequest 登录请求参数
     * @param session HTTP会话
     * @return 返回邮箱登录状态
     */
    @PostMapping("/user/email/status")
    public R loginEmailStatus(@RequestBody ConsumerRequest loginRequest, HttpSession session) {
        return consumerService.loginEmailStatus(loginRequest, session);
    }

    /**
     * 重置密码（忘记密码）
     * @param passwordRequest 重置密码请求参数
     * @return 返回重置结果
     */
    @PostMapping("/user/resetPassword")
    public R resetPassword(@RequestBody ResetPasswordRequest passwordRequest){
        Consumer user = consumerService.findByEmail(passwordRequest.getEmail());
        String code = stringRedisTemplate.opsForValue().get("code");
        if (user == null) {
            return R.fatal("用户不存在");
        } else if (!code.equals(passwordRequest.getCode())) {
            return R.fatal("验证码不存在或失效");
        }
        ConsumerRequest consumerRequest = new ConsumerRequest();
        BeanUtils.copyProperties(user, consumerRequest);
        consumerRequest.setPassword(passwordRequest.getPassword());
        consumerServiceimpl.updatePassword01(consumerRequest);

        return R.success("密码修改成功");
    }

    /**
     * 发送验证码功能
     * @param email 用户邮箱
     * @return 返回发送结果
     */
    @GetMapping("/user/sendVerificationCode")
    public R sendCode(@RequestParam String email){
        Consumer user = consumerService.findByEmail(email);
        if (user == null) {
            return R.fatal("用户不存在");
        }
        String code = RandomUtils.code();
        simpleOrderManager.sendCode(code, email);
        // 将验证码存储在Redis中
        stringRedisTemplate.opsForValue().set("code", code);
        return R.success("发送成功");
    }

    /**
     * 返回所有用户信息
     * @return 返回用户列表
     */
    @GetMapping("/user")
    public R allUser() {
        return consumerService.allUser();
    }

    /**
     * 根据用户ID返回指定用户信息
     * @param id 用户ID
     * @return 返回用户信息
     */
    @GetMapping("/user/detail")
    public R userOfId(@RequestParam int id) {
        return consumerService.userOfId(id);
    }

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return 返回删除结果
     */
    @GetMapping("/user/delete")
    public R deleteUser(@RequestParam int id) {
        return consumerService.deleteUser(id);
    }

    /**
     * 更新用户信息
     * @param updateRequest 更新请求参数
     * @return 返回更新结果
     */
    @PostMapping("/user/update")
    public R updateUserMsg(@RequestBody ConsumerRequest updateRequest) {
        return consumerService.updateUserMsg(updateRequest);
    }

    /**
     * 更新用户密码
     * @param updatePasswordRequest 更新密码请求参数
     * @return 返回更新结果
     */
    @PostMapping("/user/updatePassword")
    public R updatePassword(@RequestBody ConsumerRequest updatePasswordRequest) {
        return consumerService.updatePassword(updatePasswordRequest);
    }

    /**
     * 更新用户头像
     * @param avatorFile 头像文件
     * @param id 用户ID
     * @return 返回更新结果
     */
    @PostMapping("/user/avatar/update")
    public R updateUserPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) {
        return consumerService.updateUserAvator(avatorFile, id);
    }
}

