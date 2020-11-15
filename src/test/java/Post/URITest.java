package Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class URITest {
    private static final Logger log = LoggerFactory.getLogger(PostDAOTest.class);

    @Test
    public void URITest() throws Exception{
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/post/read")
                .queryParam("postNo",10)
                .queryParam("perPageNum",20)
                .build();
        log.info("/post/read?postNo=10&perPageNum=20");
        log.info(uriComponents.toString());
    }
}
