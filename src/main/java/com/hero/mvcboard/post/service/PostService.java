package com.hero.mvcboard.post.service;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.SearchCriteria;
import com.hero.mvcboard.post.domain.PostVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {
    void create(PostVO vo) throws Exception;
    PostVO read(Integer postNo) throws Exception;
    void update(PostVO vo) throws Exception;
    void delete(Integer postNo) throws Exception;
    List<PostVO> listAll() throws Exception;
    List<PostVO> listCriteria(Criteria cri) throws Exception;
    int countPosts(Criteria cri) throws Exception;
    List<PostVO> listSearch(SearchCriteria cri) throws Exception;
    int countSearchedPosts(SearchCriteria cri) throws Exception;
    int ExcelReadService(MultipartFile file) throws IOException;
    int getExcelRows(MultipartFile file) throws IOException;
}
