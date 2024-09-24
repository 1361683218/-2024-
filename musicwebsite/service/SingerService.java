package com.example.musicwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.Singer;
import com.example.musicwebsite.model.request.SingerRequest;
import org.springframework.web.multipart.MultipartFile;

public interface SingerService extends IService<Singer> {

    R addSinger (SingerRequest addSingerRequest);

    R updateSingerMsg(SingerRequest updateSingerRequest);

    R updateSingerPic(MultipartFile avatorFile, int id);

    R deleteSinger(Integer id);

    R allSinger();

    R singerOfName(String name);

    R singerOfSex(Integer sex);
}
