package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.SpeakerMapper;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-26 22:37
 **/
@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;


    @Override
    public List<Speaker> selectAllSpeaker() {
        List<Speaker> speakers = speakerMapper.selectByExample(null);
        return speakers;
    }

    @Override
    public PageInfo<Speaker> selectByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Speaker> speakers = speakerMapper.selectByExampleWithBLOBs(null);
        PageInfo<Speaker> pageInfo = new PageInfo<>(speakers);
        return pageInfo;
    }

    @Override
    public Speaker selectById(Integer id) {
        Speaker speaker = speakerMapper.selectByPrimaryKey(id);
        return speaker;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public void addSpeaker(Speaker speaker) {
        speakerMapper.insert(speaker);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public void updateSpeaker(Speaker speaker) {
        speakerMapper.updateByPrimaryKeyWithBLOBs(speaker);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public String deleteById(Integer id) {
        int i = speakerMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            return "success";
        }
        return "failed";
    }
}
