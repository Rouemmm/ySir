package com.qf.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: ySirWeb
 * @description: 科目相关
 * @encoder: Roue
 * @create: 2020-06-25 17:38
 **/
@Controller
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("selectAll")
    public ModelAndView selectAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Subject> subjects = subjectService.selectAll();
        modelAndView.addObject("subjectList",subjects);
        modelAndView.setViewName("/before/index.jsp");
        return modelAndView;
    }
}
