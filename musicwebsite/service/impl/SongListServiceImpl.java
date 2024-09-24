package com.example.musicwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.mapper.SongListMapper;
import com.example.musicwebsite.model.domain.SongList;
import com.example.musicwebsite.model.request.SongListRequest;
import com.example.musicwebsite.service.SongListService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {


    @Override
    public R addSongList(SongListRequest addSongListRequest) {
        return R.success("成功");
    }

    @Override
    public R updateSongListMsg(SongListRequest updateSongListRequest) {
        return R.success("成功");
    }

    @Override
    public R updateSongListImg(MultipartFile avatorFile, int id) {
        return R.success("成功");
    }

    @Override
    public R deleteSongList(Integer id) {
        return R.success("成功");
    }

    @Override
    public R allSongList() {
        return R.success("成功");
    }

    @Override
    public List<SongList> findAllSong() {
        return null;
    }

    @Override
    public R likeTitle(String title) {
        return R.success("成功");
    }

    @Override
    public R likeStyle(String style) {
        return R.success("成功");
    }


}
