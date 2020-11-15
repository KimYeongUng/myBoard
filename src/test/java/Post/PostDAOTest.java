package Post;

import com.hero.mvcboard.post.domain.PostVO;
import com.hero.mvcboard.post.persistance.PostDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class PostDAOTest {
    private static final Logger log = LoggerFactory.getLogger(PostDAOTest.class);
    @Inject
    PostDAO postDAO;

    @Test
    public void createTest() throws Exception {
        log.info("Test Create");
        PostVO vo = new PostVO();
        vo.setTitle("Testitle");
        vo.setWriter("TestWriter");
        vo.setContent("Test Content");
        postDAO.create(vo);
    }

    @Test
    public void DummyDataInsert() throws Exception{
        for(int i=0;i<1000;i++){
            PostVO vo = new PostVO();
            vo.setTitle("Test "+i);
            vo.setContent("Content "+i);
            vo.setWriter("Writer "+i);
            postDAO.create(vo);
        }
    }

    @Test
    public void readTest() throws Exception {
        log.info(postDAO.read(1).toString());
    }

    @Test
    public void updateTest() throws Exception {
        PostVO vo = new PostVO();
        vo.setPostNo(1);
        vo.setTitle("Modified Title");
        vo.setContent("Modified");
        postDAO.update(vo);
    }

    @Test
    public void deleteTest()throws Exception{
        postDAO.delete(1);
    }

    @Test
    public void listPagingTest() throws Exception{
        int page = 3;
        List<PostVO> list = postDAO.listPaging(page);
        log.info(Integer.toString(list.size()));
        for(PostVO vo : list){
            log.info(vo.getTitle()+" : "+vo.getWriter());
        }
    }

}
