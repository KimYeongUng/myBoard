package com.hero.mvcboard.post.service;

import com.hero.mvcboard.common.Paging.Criteria;
import com.hero.mvcboard.common.Paging.SearchCriteria;
import com.hero.mvcboard.post.domain.PostVO;
import com.hero.mvcboard.post.persistance.PostDAO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Inject
    public PostServiceImpl(PostDAO postDAO){
        this.postDAO = postDAO;
    }

    @Override
    public void create(PostVO vo) throws Exception {
        postDAO.create(vo);
    }

    @Override
    public PostVO read(Integer postNo) throws Exception {
        return postDAO.read(postNo);
    }

    @Override
    public void update(PostVO vo) throws Exception {
        postDAO.update(vo);
    }

    @Override
    public void delete(Integer postNo) throws Exception {
        postDAO.delete(postNo);
    }

    @Override
    public List<PostVO> listAll() throws Exception {
        return postDAO.listAll();
    }

    @Override
    public List<PostVO> listCriteria(Criteria cri) throws Exception {
        return postDAO.listCriteria(cri);
    }

    @Override
    public int countPosts(Criteria cri) throws Exception {
        return postDAO.countPosts(cri);
    }

    @Override
    public List<PostVO> listSearch(SearchCriteria cri) throws Exception {
        return postDAO.listSearch(cri);
    }

    @Override
    public int countSearchedPosts(SearchCriteria cri) throws Exception {
        return postDAO.countSearchedPosts(cri);
    }

    @Override
    public int ExcelReadService(MultipartFile file) throws IOException {
        String name  = file.getOriginalFilename().toLowerCase();
        XSSFWorkbook sheets = new XSSFWorkbook(file.getInputStream());
        int numofSheet = sheets.getNumberOfSheets();
        int numofRow,numofCell;
        String value="";
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;
        if(name.endsWith(".xlsx")){
            System.out.println("VALID");
            for(int i=1;i<numofSheet;i++){
                sheet = sheets.getSheetAt(i);
                numofRow = sheet.getPhysicalNumberOfRows();
                for(int j=0;j<numofRow;j++){
                    row = sheet.getRow(j);
                    numofCell = row.getPhysicalNumberOfCells();

                    for(int k=0;k<numofCell;k++){
                        cell = row.getCell(k);
                        switch(k){
                            case Cell.CELL_TYPE_NUMERIC:
                                value = cell.getNumericCellValue()+"";
                                break;

                            case Cell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                        }
                        if(k == 5){
                            if(cell.getStringCellValue().equals("N") || cell.getStringCellValue().equals("n") )
                                continue;
                        }
                        System.out.println(value);
                    }
                }
            }
        }else{
            throw new IOException("wrongType");
        }
        return 0;
    }

    @Override
    public int getExcelRows(MultipartFile file) throws IOException{
        XSSFWorkbook sheets = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = sheets.getSheetAt(0);

        return sheet.getPhysicalNumberOfRows();
    }

}
