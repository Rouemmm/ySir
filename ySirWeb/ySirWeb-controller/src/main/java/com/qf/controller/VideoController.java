package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import com.qf.videos.utils.Page;
import com.qf.videos.utils.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @program: ySirWeb
 * @description: 视频播放相关控制器
 * @encoder: Roue
 * @create: 2020-06-25 17:39
 **/
@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("list")
    public ModelAndView list(@RequestParam(value = "pageNum",defaultValue = "1") Integer currentPageNum, QueryVo queryVo, HttpSession session){

        System.out.println("传进来-----"+queryVo);
        QueryVo existQueryVo = (QueryVo) session.getAttribute("queryVo");
        System.out.println("existQueryVo"+existQueryVo);

        //判断用户是否使用了查询方法,如果用了查询则将该查询对象存入session中
        if ( null != queryVo.getTitle() || null != queryVo.getSpeakerId() || null != queryVo.getCourseId()) {
            session.setAttribute("queryVo",queryVo);
        } else if (null != existQueryVo) {
            //如果session域中有queryVo对象，
            queryVo = existQueryVo;
            System.out.println("修改后-----"+queryVo);
        }



        PageInfo<Video> pageInfo = videoService.selectByPage(currentPageNum,queryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("queryVo",queryVo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("/behind/videoList.jsp");
        return modelAndView;
    }

    @RequestMapping("addVideo")
    public String addVideo(){

        return "/behind/addVideo.jsp";
    }

    @RequestMapping("videoDel")
    @ResponseBody
    public String videoDel(Integer id){
        String msg = videoService.deleteById(id);
        return msg;
    }

    @RequestMapping("edit")
    public ModelAndView edit(Integer id){
        Video video = videoService.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("video",video);
        modelAndView.setViewName("/behind/addVideo.jsp");
        return modelAndView;
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Video video){
        if (video.getId() == null) {//添加功能
            videoService.addVideo(video);
        } else {//修改功能
            videoService.updateVideo(video);
        }

        return "redirect:/video/list";
    }

    @RequestMapping("delBatchVideos")
    public String delBatchVideos(@RequestParam("ids") Integer[] idsArr) {
        System.out.println(idsArr);
        List<Integer> ids= Arrays.asList(idsArr);
        videoService.delBatchVideos(ids);
        return "redirect:/video/list";
    }
}
