package com.example.musicwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.Collect;
import com.example.musicwebsite.model.request.CollectRequest;

public interface CollectService extends IService<Collect> {

    R addCollection(CollectRequest addCollectRequest);

    R existSongId(CollectRequest isCollectRequest);

    R deleteCollect(Integer userId,Integer songId);

    R collectionOfUser(Integer userId);
}
