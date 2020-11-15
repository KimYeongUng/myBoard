package com.hero.mvcboard.reply.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {
    private Integer replyNo;
    private Integer postNo;
    private String replyWriter;
    private String replyContent;
    private Date regDate;
    private Date updateDate;
}
