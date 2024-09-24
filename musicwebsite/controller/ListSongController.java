package com.example.musicwebsite.controller;

import com.alibaba.excel.EasyExcel;
import com.example.musicwebsite.common.R;
import com.example.musicwebsite.model.domain.SongList;
import com.example.musicwebsite.model.request.ListSongRequest;
import com.example.musicwebsite.service.ListSongService;
import com.example.musicwebsite.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * ListSongController类用于处理歌曲列表相关的请求。
 */
@RestController
public class ListSongController {

    @Autowired
    private ListSongService listSongService;

    @Autowired
    private SongListService service;

    /**
     * 给歌单添加歌曲。
     *
     * @param addListSongRequest 添加歌曲的请求体
     * @return 返回操作结果
     */
    @PostMapping("/listSong/add")
    public R addListSong(@RequestBody ListSongRequest addListSongRequest) {
        return listSongService.addListSong(addListSongRequest);
    }

    /**
     * 删除歌单里的歌曲。
     *
     * @param songId 歌曲 ID
     * @return 返回操作结果
     */
    @GetMapping("/listSong/delete")
    public R deleteListSong(@RequestParam int songId) {
        return listSongService.deleteListSong(songId);
    }

    /**
     * 返回指定歌单 ID 的歌曲列表。
     *
     * @param songListId 歌单 ID
     * @return 返回包含歌曲信息的结果
     */
    @GetMapping("/listSong/detail")
    public R listSongOfSongId(@RequestParam int songListId) {
        return listSongService.listSongOfSongId(songListId);
    }

    /**
     * 更新歌单里面的歌曲信息。
     *
     * @param updateListSongRequest 更新歌曲信息的请求体
     * @return 返回操作结果
     */
    @PostMapping("/listSong/update")
    public R updateListSongMsg(@RequestBody ListSongRequest updateListSongRequest) {
        return listSongService.updateListSongMsg(updateListSongRequest);
    }

    /**
     * 导出歌单。
     *
     * @param request HTTP 请求对象
     * @return 返回包含导出文件的响应
     * @throws IOException IO异常
     */
    @GetMapping("/excle")
    public ResponseEntity<Resource> getExcle(HttpServletRequest request) throws IOException {
        String fileName = "SongList" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, SongList.class).sheet("模板").doWrite(data());
        File file = new File(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        byte[] content = Files.readAllBytes(file.toPath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(content.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    /**
     * 获取所有歌曲列表数据。
     *
     * @return 包含所有歌曲的列表
     */
    private List<SongList> data() {
        List<SongList> allSong = service.findAllSong();
        return allSong;
    }

}