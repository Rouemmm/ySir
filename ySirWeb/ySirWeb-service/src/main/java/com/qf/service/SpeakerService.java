package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> selectAllSpeaker();

    PageInfo<Speaker> selectByPage(Integer pageNum);

    Speaker selectById(Integer id);

    void addSpeaker(Speaker speaker);

    void updateSpeaker(Speaker speaker);

    String deleteById(Integer id);
}
