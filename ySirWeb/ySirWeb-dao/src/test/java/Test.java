import com.qf.dao.AdminMapper;
import com.qf.dao.SpeakerMapper;
import com.qf.dao.VideoMapper;
import com.qf.pojo.Admin;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-25 14:08
 **/
public class Test {

    @org.junit.Test
    public void TestDAO(){
        AdminMapper adminMapper = (AdminMapper) new ClassPathXmlApplicationContext("application.xml").getBean("adminMapper");
        List<Admin> admins = adminMapper.selectByExample(null);
        System.out.println(admins);
    }

    @org.junit.Test
    public void TestSelect(){
        VideoMapper videoMapper = (VideoMapper) new ClassPathXmlApplicationContext("application.xml").getBean("videoMapper");
        List<Video> videos = videoMapper.selectAllInnerOnSpeaker();
        System.out.println(videos);
    }

    @org.junit.Test
    public void TestPageInfo(){

    }

    @org.junit.Test
    public void testSpeakerSelectByExampleWithBLOBs(){
        SpeakerMapper speakerMapper = (SpeakerMapper) new ClassPathXmlApplicationContext("application.xml").getBean("speakerMapper");
        List<Speaker> speakers = speakerMapper.selectByExampleWithBLOBs(null);
        System.out.println(speakers);
    }
}

