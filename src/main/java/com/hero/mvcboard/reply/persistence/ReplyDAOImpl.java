package com.hero.mvcboard.reply.persistence;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.reply.domain.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
    private static final String NAMESPACE = "com.hero.mvcboard.mappers.reply.ReplyMapper";
    private final SqlSession sqlSession;

    @Inject
    public ReplyDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ReplyVO> list(Integer postNo) throws Exception {
        return sqlSession.selectList(NAMESPACE+".list",postNo);
    }

    @Override
    public void create(ReplyVO vo) throws Exception {
        sqlSession.insert(NAMESPACE+".create",vo);
    }

    @Override
    public void update(ReplyVO vo) throws Exception {
        sqlSession.update(NAMESPACE+".update",vo);
    }

    @Override
    public void delete(Integer replyNo) throws Exception {
        sqlSession.delete(NAMESPACE+".delete",replyNo);
    }

    @Override
    public List<ReplyVO> listpaging(Integer postNo, Criteria cri) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("postNo",postNo);
        map.put("cri",cri);
        return sqlSession.selectList(NAMESPACE+".listpaging",map);
    }

    @Override
    public int getReplyCount(Integer postNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE+".countReply",postNo);
    }
}
