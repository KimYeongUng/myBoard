package com.hero.mvcboard.common.Paging;

public class Criteria {
    private int page;
    private int perPageNum;

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPage(int page){
        if(page<=0){
            page=1;
            return;
        }
        this.page = page;
    }

    public int getPage(){
        return this.page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum<=0) {
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPerPageNum(){
        return this.perPageNum;
    }

    public int getPageStart(){
        return (page-1)*perPageNum;
    }
}
