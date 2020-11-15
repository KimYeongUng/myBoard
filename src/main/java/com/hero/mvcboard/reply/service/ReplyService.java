package com.hero.mvcboard.reply.service;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.reply.domain.ReplyVO;

import java.util.List;

public interface ReplyService {
    List<ReplyVO> list(Integer postNo)throws Exception;
    void create(ReplyVO vo) throws Exception;
    void update(ReplyVO vo) throws Exception;
    void delete(Integer replyNo) throws Exception;
    List<ReplyVO> listPaging(Integer postNo, Criteria cri) throws Exception;
    int countReply(Integer postNo) throws Exception;
}
