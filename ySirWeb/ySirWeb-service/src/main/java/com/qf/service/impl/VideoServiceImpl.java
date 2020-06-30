package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.VideoMapper;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import com.qf.videos.utils.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-26 17:01
 **/
@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public PageInfo<Video> selectByPage(int current, QueryVo queryVo) {
        //传入当前页，以及当前页总数
        PageHelper.startPage(current,5);
        //查询所有video
        List<Video> videos = videoMapper.selectByQueryVo(queryVo);
        //将videos传入PageInfo
        PageInfo<Video> videoPageInfo = new PageInfo<>(videos);

        return videoPageInfo;
    }

    @Override
    public String deleteById(Integer id) {
        int i = videoMapper.deleteByPrimaryKey(id);
        if (i > 0 ){
            return "success";
        }
        return "failed";
    }

    @Override
    public Video selectById(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addVideo(Video video) {
        videoMapper.insert(video);
    }

    @Override
    public void updateVideo(Video video) {
        videoMapper.updateByPrimaryKey(video);
    }

    @Override
    public void delBatchVideos(List<Integer> ids) {
        for (Integer id : ids) {
            deleteById(id);
        }
    }

    @Override
    public PageInfo<Video> selectByQueryVo(QueryVo queryVo) {
        return null;
    }
}
