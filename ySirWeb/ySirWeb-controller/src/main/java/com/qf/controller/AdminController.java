package com.qf.controller;

import com.qf.pojo.Admin;
import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.service.AdminService;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: ySirWeb
 * @description: Admin表相关的控制器
 * @encoder: Roue
 * @create: 2020-06-25 17:37
 **/
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    CourseController courseController;
    @Autowired
    SpeakerController speakerController;

    @RequestMapping("loginView")
    public String loginView(){
        return "/behind/login.jsp";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request){
        admin = adminService.selectAdminByNameAndPwd(admin.getUsername(),admin.getPassword());
        if (null != admin) {
            HttpSession session = request.getSession();
            List<Course> courseList = courseController.selectAllCourse();
            List<Speaker> speakerList = speakerController.selectAllSpeaker();
            session.setAttribute("speakerList",speakerList);
            session.setAttribute("courseList",courseList);
            session.setAttribute("userName",admin.getUsername());
            return "success";
        }
        return "failed";
    }

    @RequestMapping("exit")
    public String exit(HttpSession session){

        session.removeAttribute("userName");
        return "/behind/login.jsp";
    }

}
