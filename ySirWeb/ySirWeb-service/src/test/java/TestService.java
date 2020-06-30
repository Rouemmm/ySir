import com.github.pagehelper.PageInfo;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-26 19:54
 **/
public class TestService {
    @Test
    public void testPageInfo(){
        VideoService videoService = (VideoService) new ClassPathXmlApplicationContext("application.xml").getBean("videoService");
//        PageInfo<Video> videoPageInfo = videoService.selectByPage(1,queryVo);
//        System.out.println(videoPageInfo);
    }


}
