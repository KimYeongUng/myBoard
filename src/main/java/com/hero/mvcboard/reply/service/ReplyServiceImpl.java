package com.hero.mvcboard.reply.service;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.reply.domain.ReplyVO;
import com.hero.mvcboard.reply.persistence.ReplyDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Inject
    ReplyDAO dao;

    @Override
    public List<ReplyVO> list(Integer postNo) throws Exception {
        return dao.list(postNo);
    }

    @Override
    public void create(ReplyVO vo) throws Exception {
        dao.create(vo);
    }

    @Override
    public void update(ReplyVO vo) throws Exception {
        dao.update(vo);
    }

    @Override
    public void delete(Integer replyNo) throws Exception {
        dao.delete(replyNo);
    }

    @Override
    public List<ReplyVO> listPaging(Integer postNo, Criteria cri) throws Exception {
        return dao.listpaging(postNo,cri);
    }

    @Override
    public int countReply(Integer postNo) throws Exception {
        return dao.getReplyCount(postNo);
    }


}
