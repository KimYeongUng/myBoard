package com.hero.mvcboard.post.persistance;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.SearchCriteria;
import com.hero.mvcboard.post.domain.PostVO;

import java.util.List;

public interface PostDAO {
    void create(PostVO vo) throws Exception;
    PostVO read(Integer postNo) throws Exception;
    void update(PostVO vo) throws Exception;
    void delete(Integer postNo) throws Exception;
    List<PostVO> listAll() throws Exception;
    List<PostVO> listPaging(int page) throws Exception;
    List<PostVO> listCriteria(Criteria cri) throws Exception;
    int countPosts(Criteria cri) throws Exception;
    List<PostVO> listSearch(SearchCriteria cri) throws Exception;
    int countSearchedPosts(SearchCriteria cri) throws Exception;
}
