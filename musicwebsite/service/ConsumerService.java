package com.example.musicwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.Consumer;
import com.example.musicwebsite.model.request.ConsumerRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface ConsumerService extends IService<Consumer> {

    R addUser(ConsumerRequest registryRequest) ;
    boolean existUser(String username);

    boolean verityPasswd(String username, String password);
    R loginStatus(ConsumerRequest loginRequest, HttpSession session);

}
