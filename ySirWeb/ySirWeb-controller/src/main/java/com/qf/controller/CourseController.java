package com.qf.controller;

import com.qf.pojo.Course;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-25 17:38
 **/
@Controller

public class CourseController {
    @Autowired
    private CourseService courseService;


    public List<Course> selectAllCourse() {
        return courseService.selectAllCourse();
    }

    @RequestMapping("showCourseList")
    public String showCourseList(){
        return "before/course.jsp";
    }
}
