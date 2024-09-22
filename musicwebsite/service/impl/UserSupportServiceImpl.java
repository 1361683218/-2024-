package com.example.musicwebsite.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.UserSupportMapper;
import com.example.musicwebsite.model.domain.UserSupport;
import com.example.musicwebsite.model.request.UserSupportRequest;
import com.example.musicwebsite.service.UserSupportService;
import org.springframework.stereotype.Service;

/**
 * @author asus
 * @description 针对表【user_support】的数据库操作Service实现
 */
@Service
public class UserSupportServiceImpl extends ServiceImpl<UserSupportMapper, UserSupport> implements UserSupportService {


    @Override
    public R isUserSupportComment(UserSupportRequest userSupportRequest) {
        return null;
    }

    @Override
    public R insertCommentSupport(UserSupportRequest userSupportRequest) {
        return null;
    }

    @Override
    public R deleteCommentSupport(UserSupportRequest userSupportRequest) {
        return null;
    }
}
