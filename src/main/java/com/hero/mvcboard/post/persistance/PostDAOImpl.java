package com.hero.mvcboard.post.persistance;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.SearchCriteria;
import com.hero.mvcboard.post.domain.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {
    private static final String NAMESPACE = "com.hero.mvcboard.mappers.post.PostMapper";

    private final SqlSession sqlSession;

    @Inject
    public PostDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(PostVO vo) throws Exception {
        sqlSession.insert(NAMESPACE+".create",vo);
    }

    @Override
    public PostVO read(Integer postNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".read",postNo);
    }

    @Override
    public void update(PostVO vo) throws Exception {
        sqlSession.update(NAMESPACE+".update",vo);

    }

    @Override
    public void delete(Integer postNo) throws Exception {
        sqlSession.delete(NAMESPACE+".delete",postNo);
    }

    @Override
    public List<PostVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE+".listAll");
    }

    @Override
    public List<PostVO> listPaging(int page) throws Exception {
        if(page<=0)
            page =1;

        page = (page-1)*10;

        return sqlSession.selectList(NAMESPACE+".listPaging",page);
    }

    @Override
    public List<PostVO> listCriteria(Criteria cri) throws Exception {
        return sqlSession.selectList(NAMESPACE+".listCriteria",cri);
    }

    @Override
    public int countPosts(Criteria cri) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".countPosts",cri);
    }

    @Override
    public List<PostVO> listSearch(SearchCriteria cri) throws Exception {
        return sqlSession.selectList(NAMESPACE+".listSearch",cri);
    }

    @Override
    public int countSearchedPosts(SearchCriteria cri) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".countSearchedPosts",cri);
    }


}
