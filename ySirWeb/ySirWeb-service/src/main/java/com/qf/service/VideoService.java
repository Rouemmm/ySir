package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.Video;
import com.qf.videos.utils.QueryVo;

import java.util.List;


public interface VideoService {
    PageInfo<Video> selectByPage(int current, QueryVo queryVo);

    String deleteById(Integer id);

    Video selectById(Integer id);

    void addVideo(Video video);

    void updateVideo(Video video);

    void delBatchVideos(List<Integer> ids);

    PageInfo<Video> selectByQueryVo(QueryVo queryVo);
}
