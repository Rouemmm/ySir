package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ySirWeb
 * @description: 讲师相关控制器
 * @encoder: Roue
 * @create: 2020-06-25 17:38
 **/
@Controller
@RequestMapping("speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("showSpeakerList")
    public ModelAndView showSpeakerList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageInfo<Speaker> pageInfo = speakerService.selectByPage(pageNum);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("/behind/speakerList.jsp");
        return modelAndView;
    }

    @RequestMapping("addSpeaker")
    public String addSpeaker(){
        return "/behind/addSpeaker.jsp";
    }

    @RequestMapping("edit")
    public ModelAndView edit(Integer id){
        Speaker inputSpeaker = speakerService.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("speaker",inputSpeaker);
        modelAndView.setViewName("/behind/addSpeaker.jsp");
        return modelAndView;
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
        if (null != speaker.getId()) {
            //传过来的有id，说明是添加
            speakerService.updateSpeaker(speaker);
        }else {
            //传过来的没有id，说明是修改
            speakerService.addSpeaker(speaker);
        }
        return "redirect:/speaker/showSpeakerList";
    }

    @RequestMapping("speakerDel")
    @ResponseBody
    public String speakerDel(Integer id){
        String msg = speakerService.deleteById(id);
        return msg;
    }

    public List<Speaker> selectAllSpeaker() {
        return speakerService.selectAllSpeaker();
    }
}
