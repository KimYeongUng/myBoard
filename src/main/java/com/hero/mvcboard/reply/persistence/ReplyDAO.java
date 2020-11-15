package com.hero.mvcboard.reply.persistence;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.reply.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {
    List<ReplyVO> list(Integer postNo) throws Exception;
    void create(ReplyVO vo) throws Exception;
    void update(ReplyVO vo) throws Exception;
    void delete(Integer replyNo) throws Exception;
    List<ReplyVO> listpaging(Integer postNo,Criteria cri) throws Exception;
    int getReplyCount(Integer postNo) throws Exception;
}
