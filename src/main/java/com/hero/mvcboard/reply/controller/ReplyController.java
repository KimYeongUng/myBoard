package com.hero.mvcboard.reply.controller;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.PageMaker;
import com.hero.mvcboard.reply.domain.ReplyVO;
import com.hero.mvcboard.reply.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    private final ReplyService replyService;

    @Inject
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<String> write(@RequestBody ReplyVO vo){
        ResponseEntity<String> entity;
        try {
            replyService.create(vo);
            entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/all/{postNo}",method = RequestMethod.GET)
    public ResponseEntity<List<ReplyVO>> list(@PathVariable("postNo")Integer postNo){
        ResponseEntity<List<ReplyVO>> entity;
        try {
            entity = new ResponseEntity<>(replyService.list(postNo),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/{replyNo}",method = {RequestMethod.PUT,RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("replyNo")Integer replyNo,@RequestBody ReplyVO vo){
        ResponseEntity<String> entity;

        try {
            vo.setReplyNo(replyNo);
            replyService.update(vo);
            entity = new ResponseEntity<>("modSuccess",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/{replyNo}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("replyNo")Integer replyNo){
        ResponseEntity<String> entity;

        try {
            replyService.delete(replyNo);
            entity = new ResponseEntity<>("delSuccess",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/{postNo}/{page}",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> listPaging(@PathVariable("postNo")Integer postNo,@PathVariable("page")Integer page){
        ResponseEntity<Map<String,Object>> entity;

        try {
            Criteria cri = new Criteria();
            cri.setPage(page);

            List<ReplyVO> replies = replyService.listPaging(postNo,cri);
            int numofReply = replyService.countReply(postNo);

            PageMaker pageMaker = new PageMaker();
            pageMaker.setCriteria(cri);
            pageMaker.setTotalCount(numofReply);

            Map<String,Object> map = new HashMap<>();
            map.put("replies",replies);
            map.put("pageMaker",pageMaker);

            entity = new ResponseEntity<>(map,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.OK);
        }

        return entity;
    }
}
