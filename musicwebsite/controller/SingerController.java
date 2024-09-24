package com.example.musicwebsite.controller;

import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.request.SingerRequest;
import com.example.musicwebsite.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 控制器类，用于处理与歌手相关的请求。
 */
@RestController
public class SingerController {

    @Autowired
    private SingerService singerService;

    /**
     * 添加歌手
     *
     * @param addSingerRequest 包含添加歌手信息的请求对象
     * @return 添加结果的响应
     */
    @PostMapping("/singer/add")
    public R addSinger(@RequestBody SingerRequest addSingerRequest) {
        return singerService.addSinger(addSingerRequest);
    }

    /**
     * 删除歌手
     *
     * @param id 歌手的唯一标识符
     * @return 删除结果的响应
     */
    @DeleteMapping("/singer/delete")
    public R deleteSinger(@RequestParam int id) {
        return singerService.deleteSinger(id);
    }

    /**
     * 返回所有歌手
     *
     * @return 所有歌手的响应
     */
    @GetMapping("/singer")
    public R allSinger() {
        return singerService.allSinger();
    }

    /**
     * 根据歌手名查找歌手
     *
     * @param name 歌手的姓名
     * @return 查找到的歌手的响应
     */
    @GetMapping("/singer/name/detail")
    public R singerOfName(@RequestParam String name) {
        return singerService.singerOfName(name);
    }

    /**
     * 根据歌手性别查找歌手
     *
     * @param sex 歌手的性别（例如，0：男性，1：女性）
     * @return 查找到的歌手的响应
     */
    @GetMapping("/singer/sex/detail")
    public R singerOfSex(@RequestParam int sex) {
        return singerService.singerOfSex(sex);
    }

    /**
     * 更新歌手信息
     *
     * @param updateSingerRequest 包含更新歌手信息的请求对象
     * @return 更新结果的响应
     */
    @PostMapping("/singer/update")
    public R updateSingerMsg(@RequestBody SingerRequest updateSingerRequest) {
        return singerService.updateSingerMsg(updateSingerRequest);
    }

    /**
     * 更新歌手头像
     *
     * @param avatorFile 歌手头像文件
     * @param id 歌手的唯一标识符
     * @return 更新结果的响应
     */
    @PostMapping("/singer/avatar/update")
    public R updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) {
        return singerService.updateSingerPic(avatorFile, id);
    }
}