package reply;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.reply.domain.ReplyVO;
import com.hero.mvcboard.reply.persistence.ReplyDAO;
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
public class ReplyDAOTest {
    private static final Logger log = LoggerFactory.getLogger(ReplyDAOTest.class);

    @Inject
    private ReplyDAO dao;

    @Test
    public void testReplyCreate() throws Exception {
        for(int i=1;i<=100;i++){
            ReplyVO vo = new ReplyVO();
            vo.setPostNo(1005);
            vo.setReplyContent("Reply No."+i);
            vo.setReplyWriter("User"+i);
            dao.create(vo);
        }
    }

    @Test
    public void testList() throws Exception{
        log.info(dao.list(1005).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        ReplyVO vo = new ReplyVO();
        vo.setPostNo(1005);
        vo.setReplyContent("reply Modified...");
        dao.update(vo);
    }

    @Test
    public void testRemoveReply() throws Exception {
        dao.delete(1);
    }

    @Test
    public void testListPage() throws Exception{
        Criteria cri = new Criteria();
        cri.setPage(1);
        cri.setPerPageNum(10);
        List<ReplyVO> list = dao.listpaging(1005,cri);
        for (ReplyVO co:list)
            log.info(co.getReplyNo()+" "+co.getReplyContent());
     }

}
