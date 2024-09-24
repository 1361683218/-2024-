package com.example.musicwebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.CollectMapper;
import com.example.musicwebsite.model.domain.Collect;
import com.example.musicwebsite.model.request.CollectRequest;
import com.example.musicwebsite.service.CollectService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Override
    public R addCollection(CollectRequest addCollectRequest) {
        return R.success("成功");
    }

    @Override
    public R existSongId(CollectRequest isCollectRequest) {
        return R.success("成功");
    }

    @Override
    public R deleteCollect(Integer userId, Integer songId) {
        return R.success("成功");
    }

    @Override
    public R collectionOfUser(Integer userId) {
       return R.success("成功");
    }
}
