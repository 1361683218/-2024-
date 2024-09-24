package com.example.musicwebsite.controller;

import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.request.SongListRequest;
import com.example.musicwebsite.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 歌单控制器类，用于处理与歌单相关的HTTP请求。
 */
@RestController
public class SongListController {

    /** 歌单服务对象，用于执行与歌单相关的业务逻辑。 */
    @Autowired
    private SongListService songListService;

    /**
     * 添加新的歌单。
     *
     * @param addSongListRequest 包含新歌单信息的请求体
     * @return 操作结果响应
     */
    @PostMapping("/songList/add")
    public R addSongList(@RequestBody SongListRequest addSongListRequest) {
        return songListService.addSongList(addSongListRequest);
    }

    /**
     * 删除指定ID的歌单。
     *
     * @param id 要删除的歌单的ID
     * @return 操作结果响应
     */
    @GetMapping("/songList/delete")
    public R deleteSongList(@RequestParam int id) {
        return songListService.deleteSongList(id);
    }

    /**
     * 获取所有歌单列表。
     *
     * @return 所有歌单的信息响应
     */
    @GetMapping("/songList")
    public R allSongList() {
        return songListService.allSongList();
    }

    /**
     * 根据歌单标题的部分匹配获取歌单列表。
     *
     * @param title 需要匹配的歌单标题的一部分
     * @return 匹配到的歌单列表响应
     */
    @GetMapping("/songList/likeTitle/detail")
    public R songListOfLikeTitle(@RequestParam String title) {
        return songListService.likeTitle('%' + title + '%');
    }

    /**
     * 根据歌单类型的部分匹配获取歌单列表。
     *
     * @param style 需要匹配的歌单类型的一部分
     * @return 匹配到的歌单列表响应
     */
    @GetMapping("/songList/style/detail")
    public R songListOfStyle(@RequestParam String style) {
        return songListService.likeStyle('%' + style + '%');
    }

    /**
     * 更新指定歌单的信息。
     *
     * @param updateSongListRequest 包含更新信息的请求体
     * @return 操作结果响应
     */
    @PostMapping("/songList/update")
    public R updateSongListMsg(@RequestBody SongListRequest updateSongListRequest) {
        return songListService.updateSongListMsg(updateSongListRequest);
    }

    /**
     * 更新指定歌单的封面图片。
     *
     * @param avatorFile 歌单的新封面图片文件
     * @param id 要更新封面图片的歌单ID
     * @return 操作结果响应
     */
    @PostMapping("/songList/img/update")
    public R updateSongListPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) {
        return songListService.updateSongListImg(avatorFile, id);
    }
}