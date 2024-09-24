package com.example.musicwebsite.controller;

import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.request.SongRequest;
import com.example.musicwebsite.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

/**
 * 控制器，用于管理歌曲相关的HTTP请求。
 */
@RestController
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 配置Multipart请求的文件上传限制。
     *
     * @return MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大20M
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // 设置总上传数据的最大大小为20M
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    /**
     * 添加歌曲。
     *
     * @param addSongRequest 歌曲请求数据
     * @param lrcfile       歌词文件
     * @param mpfile        音乐文件
     * @return R 操作结果
     */
    @PostMapping("/song/add")
    public R addSong(SongRequest addSongRequest, @RequestParam("lrcfile") MultipartFile lrcfile, @RequestParam("file") MultipartFile mpfile) {
        return songService.addSong(addSongRequest, lrcfile, mpfile);
    }

    /**
     * 删除指定ID的歌曲。
     *
     * @param id 歌曲ID
     * @return R 操作结果
     */
    @DeleteMapping("/song/delete")
    public R deleteSong(@RequestParam int id) {
        return songService.deleteSong(id);
    }

    /**
     * 返回所有歌曲信息。
     *
     * @return R 所有歌曲的列表
     */
    @GetMapping("/song")
    public R allSong() {
        return songService.allSong();
    }

    /**
     * 返回指定ID的歌曲详细信息。
     *
     * @param id 歌曲ID
     * @return R 歌曲的详细信息
     */
    @GetMapping("/song/detail")
    public R songOfId(@RequestParam int id) {
        return songService.songOfId(id);
    }

    /**
     * 返回指定歌手ID的歌曲。
     *
     * @param singerId 歌手ID
     * @return R 歌手的歌曲列表
     */
    @GetMapping("/song/singer/detail")
    public R songOfSingerId(@RequestParam int singerId) {
        return songService.songOfSingerId(singerId);
    }

    /**
     * 返回指定歌手名的歌曲。
     *
     * @param name 歌手名
     * @return R 歌手名匹配的歌曲列表
     */
    @GetMapping("/song/singerName/detail")
    public R songOfSingerName(@RequestParam String name) {
        return songService.songOfSingerName('%' + name + '%');
    }

    /**
     * 更新歌曲信息。
     *
     * @param updateSongRequest 包含更新信息的歌曲请求数据
     * @return R 操作结果
     */
    @PostMapping("/song/update")
    public R updateSongMsg(@RequestBody SongRequest updateSongRequest) {
        return songService.updateSongMsg(updateSongRequest);
    }

    /**
     * 更新歌曲图片。
     *
     * @param urlFile 图片文件
     * @param id     歌曲ID
     * @return R 操作结果
     */
    @PostMapping("/song/img/update")
    public R updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return songService.updateSongPic(urlFile, id);
    }

    /**
     * 更新歌曲文件地址。
     *
     * @param urlFile 歌曲文件
     * @param id     歌曲ID
     * @return R 操作结果
     */
    @PostMapping("/song/url/update")
    public R updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return songService.updateSongUrl(urlFile, id);
    }

    /**
     * 更新歌词文件。
     *
     * @param lrcFile 歌词文件
     * @param id     歌曲ID
     * @return R 操作结果
     */
    @PostMapping("/song/lrc/update")
    public R updateSongLrc(@RequestParam("file") MultipartFile lrcFile, @RequestParam("id") int id) {
        return songService.updateSongLrc(lrcFile, id);
    }
}