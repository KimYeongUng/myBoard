package com.hero.mvcboard.post.controller;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.PageMaker;
import com.hero.mvcboard.common.Paging.SearchCriteria;
import com.hero.mvcboard.post.domain.PostVO;
import com.hero.mvcboard.post.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService service;

    @Inject
    public PostController(PostService service){
        this.service = service;
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String writeGet(){
        logger.info("write GET....");

        return "/post/write";
    }

    @RequestMapping(value = "/write",method = RequestMethod.POST)
    public String wrtiePost(PostVO vo, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("write POST");
        logger.info(vo.toString());
        service.create(vo);
        redirectAttributes.addFlashAttribute("msg","regSuccess");

        return "redirect:/post/listCriteria";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        logger.info("list....");
        model.addAttribute("posts",service.listAll());
        return "/post/list";
    }

    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public String read(@ModelAttribute("cri") SearchCriteria cri,@RequestParam("postNo") int postNo, Model model) throws Exception {
        logger.info("read....");
        logger.info("searchType: "+cri.getSearchType()+" Keyword: "+cri.getKeyword());
        model.addAttribute("post",service.read(postNo));

        return "/post/read";
    }

    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    public String modifyGet(@ModelAttribute("cri") SearchCriteria cri,@RequestParam("postNo")int postNo,Model model) throws Exception {
        logger.info("modify get...");

        model.addAttribute("post",service.read(postNo));

        return "/post/modify";
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modifyPost(SearchCriteria cri,PostVO vo,RedirectAttributes redirectAttributes) throws Exception {
        logger.info("modify POST....");
        service.update(vo);
        redirectAttributes.addAttribute("page",cri.getPage());
        redirectAttributes.addAttribute("perPageNum",cri.getPerPageNum());
        redirectAttributes.addAttribute("searchType",cri.getSearchType());
        redirectAttributes.addAttribute("keyword",cri.getKeyword());
        redirectAttributes.addFlashAttribute("msg","modSuccess");

        return "redirect:/post/listCriteria";
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public String remove(SearchCriteria cri,@RequestParam("postNo")int postNo,RedirectAttributes redirectAttributes) throws Exception {
        logger.info("remove....");
        service.delete(postNo);
        redirectAttributes.addAttribute("page",cri.getPage());
        redirectAttributes.addAttribute("perPageNum",cri.getPerPageNum());
        redirectAttributes.addAttribute("searchType",cri.getSearchType());
        redirectAttributes.addAttribute("keyword",cri.getKeyword());
        redirectAttributes.addFlashAttribute("msg","delSuccess");
        return "redirect:/post/listCriteria";
    }

    @RequestMapping(value = "/listCriteria", method= RequestMethod.GET)
    public String listCriteria(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
        logger.info("list Cri...");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(cri);
        pageMaker.setTotalCount(service.countSearchedPosts(cri));
        logger.info(pageMaker.isNext()+" "+pageMaker.isPrev()+" "+pageMaker.getTotalCount());
        logger.info("startPage: "+pageMaker.getStartPage()+" endPage: "+pageMaker.getEndPage());
        model.addAttribute("posts",service.listSearch(cri));
        model.addAttribute("pageMaker",pageMaker);

        return "/post/list_criteria";
    }

    @RequestMapping(value="ajax/2/terminal/ExcelStockReader")
    @ResponseBody
    public String ExcelReader(@ModelAttribute ModelMap model, MultipartFile file) throws IOException {
        String filename = "";
        FileInputStream efile = new FileInputStream(filename);
        XSSFWorkbook book = new XSSFWorkbook(efile);

        return "";
    }
}
