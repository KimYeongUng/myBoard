package Post;


import com.hero.mvcboard.common.Paging.SearchCriteria;
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
public class SQLTest {
    private static Logger log = LoggerFactory.getLogger(SQLTest.class);
    @Inject
    PostDAO dao;

    @Test
    public void testDynamicSql() throws Exception {
        SearchCriteria cri = new SearchCriteria();
        cri.setPage(1);
        cri.setKeyword("Modified");
        cri.setSearchType("t");

        log.info("========== List ==========");

        List<PostVO> list = dao.listSearch(cri);

        for (PostVO vo:list)
            log.info(vo.getTitle()+" "+vo.getPostNo());

        log.info("============================");

        int count = dao.countSearchedPosts(cri);

        log.info("Searched Count: "+count);
    }
}
