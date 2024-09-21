package com.example.musicwebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.musicwebsite.model.domain.Song;
import org.springframework.stereotype.Repository;

@Repository
public interface SongMapper extends BaseMapper<Song> {

}
