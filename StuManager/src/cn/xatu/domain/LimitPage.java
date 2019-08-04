package cn.xatu.domain;

import java.util.List;

/**
 * 分页对象
 * 为了后期的通用，使用自定义泛型T,在以后初始化LimitPage的时候初始化T就达成了通用
 */
public class LimitPage<T> {
    //当前页
    private int currentPage;
    //总记录数据：totalCount
    private int totalCount;
    //页面大小,每页显示的条数
    private int pageSize;
    //总页码：totalPage
    private int totalPage;
    //每页的数据
    private List<T> list;
    //当我们调用了总数据和页面大小的setter，就会自动计算出总页数
    //总页数=总数据数%页面大小==0？总数据数/页面大小：总数据数/页面大小+1
    //先set总数据数，再色图页面大小，不然可能会有空指针异常
    public LimitPage(int currentPage, int totalCount, int pageSize, int totalPage, List<T> list){
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.list = list;
    }
    public LimitPage(){}

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //计算总页数
        this.totalPage = this.totalCount % this.pageSize==0 ? this.totalCount/this.pageSize : this.totalCount/this.pageSize+1;
    }
    public int getTotalPage() {
        return totalPage;
    }

    public List <T> getList() {
        return list;
    }

    public void setList(List <T> list) {
        this.list = list;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
