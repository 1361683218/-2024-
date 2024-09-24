package com.example.musicwebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.ListSongMapper;
import com.example.musicwebsite.model.domain.ListSong;
import com.example.musicwebsite.model.request.ListSongRequest;
import com.example.musicwebsite.service.ListSongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements ListSongService {


    @Override
    public R addListSong(ListSongRequest addListSongRequest) {
        return R.success("成功");
    }

    @Override
    public R updateListSongMsg(ListSongRequest updateListSongRequest) {
        return R.success("成功");
    }

    @Override
    public R deleteListSong(Integer songId) {
        return R.success("成功");
    }

    @Override
    public List<ListSong> allListSong() {
        return null;
    }

    @Override
    public R listSongOfSongId(Integer songListId) {
        return R.success("成功");
    }
}
