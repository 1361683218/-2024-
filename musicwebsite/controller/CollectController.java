package com.example.musicwebsite.controller;

import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.request.CollectRequest;
import com.example.musicwebsite.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 添加收藏的歌曲。
     *
     * @param addCollectRequest 包含要收藏歌曲的请求对象
     * @return 包含操作结果的响应对象
     */
    @PostMapping("/collection/add")
    public R addCollection(@RequestBody CollectRequest addCollectRequest) {
        return collectService.addCollection(addCollectRequest);
    }

    /**
     * 取消收藏的歌曲。
     *
     * @param userId 用户的ID
     * @param songId 歌曲的ID
     * @return 包含操作结果的响应对象
     */
    @DeleteMapping("/collection/delete")
    public R deleteCollection(@RequestParam Integer userId, @RequestParam Integer songId) {
        return collectService.deleteCollect(userId, songId);
    }

    /**
     * 检查歌曲是否已被收藏。
     *
     * @param isCollectRequest 包含用于检查的歌曲请求对象
     * @return 包含检查结果的响应对象
     */
    @PostMapping("/collection/status")
    public R isCollection(@RequestBody CollectRequest isCollectRequest) {
        return collectService.existSongId(isCollectRequest);
    }

    /**
     * 获取指定用户ID的收藏列表。
     *
     * @param userId 用户的ID
     * @return 包含收藏歌曲列表的响应对象
     */
    @GetMapping("/collection/detail")
    public R collectionOfUser(@RequestParam Integer userId) {
        return collectService.collectionOfUser(userId);
    }
}