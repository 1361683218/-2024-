package com.example.musicwebsite.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.SongMapper;
import com.example.musicwebsite.model.domain.Song;
import com.example.musicwebsite.model.request.SongRequest;
import com.example.musicwebsite.service.SongService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {


    @Override
    public R addSong(SongRequest addSongRequest, MultipartFile lrcfile, MultipartFile mpfile) {
        return null;
    }

    @Override
    public R updateSongMsg(SongRequest updateSongRequest) {
        return null;
    }

    @Override
    public R updateSongUrl(MultipartFile urlFile, int id) {
        return null;
    }

    @Override
    public R updateSongPic(MultipartFile urlFile, int id) {
        return null;
    }

    @Override
    public R deleteSong(Integer id) {
        return null;
    }

    @Override
    public R allSong() {
        return null;
    }

    @Override
    public R songOfSingerId(Integer singerId) {
        return null;
    }

    @Override
    public R songOfId(Integer id) {
        return null;
    }

    @Override
    public R songOfSingerName(String name) {
        return null;
    }

    @Override
    public R updateSongLrc(MultipartFile lrcFile, int id) {
        return null;
    }
}
