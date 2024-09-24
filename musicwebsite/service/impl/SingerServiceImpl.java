package com.example.musicwebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.SingerMapper;
import com.example.musicwebsite.model.domain.Singer;
import com.example.musicwebsite.model.request.SingerRequest;
import com.example.musicwebsite.service.SingerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {


    @Override
    public R addSinger(SingerRequest addSingerRequest) {
        return R.success("成功");
    }

    @Override
    public R updateSingerMsg(SingerRequest updateSingerRequest) {
        return R.success("成功");
    }

    @Override
    public R updateSingerPic(MultipartFile avatorFile, int id) {
        return R.success("成功");
    }

    @Override
    public R deleteSinger(Integer id) {
        return R.success("成功");
    }

    @Override
    public R allSinger() {
        return R.success("成功");
    }

    @Override
    public R singerOfName(String name) {
        return R.success("成功");
    }

    @Override
    public R singerOfSex(Integer sex) {
        return R.success("成功");
    }
}
