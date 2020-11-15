package com.hero.mvcboard.post.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PostVO {
    private Integer postNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;
}
