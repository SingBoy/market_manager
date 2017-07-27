package com.sigal.common.pagination.model;

import java.util.List;

/**
 * 简单分页列表
 * @author LOMI
 *
 * @param <T>
 */
public class Pagination<T> implements PaginationList<T> {

    private static final long serialVersionUID = 1L;

    private int pageNo = 1;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int totalSize = 0;

    private List<T> pageRecords = null;

    private List<T> totalRecords = null;

    private int pageCount;

    private void adjustPage() {
        if(this.totalRecords != null) {
            this.totalSize = this.totalRecords.size();
        }
        if(this.totalSize < 0) {
            this.totalSize = 0;
            this.pageRecords = null;
        }
        this.pageSize = pageSize > 0?pageSize:DEFAULT_PAGE_SIZE;
        this.pageCount = (this.totalSize - 1) / this.pageSize + 1;
        if(this.pageNo > this.pageCount) this.pageNo = this.pageCount;
        if(this.pageNo <= 0) this.pageNo = 1;

        if(this.totalRecords != null && this.totalSize > 0) {
            int fromIndex = (this.pageNo - 1) * this.pageSize;
            int toIndex = fromIndex + this.pageSize;
            if(toIndex > this.totalRecords.size()) {
                toIndex = this.totalRecords.size();
            }
            this.pageRecords = this.totalRecords.subList(fromIndex, toIndex);
        }
    }

    public Pagination(List<T> pageRecords, int pageNo, int pageSize, int totalSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageRecords = pageRecords;
        this.totalSize = totalSize;

        adjustPage();
    }

    public Pagination(List<T> totalRecords, int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;

        adjustPage();
    }

    public Pagination(List<T> totalRecords, int pageNo) {
        this.pageNo = pageNo;
        this.totalRecords = totalRecords;

        adjustPage();
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getPageNo() {
        return this.pageNo;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public int getTotalSize() {
        return this.totalSize;
    }

    @Override
    public List<T> getPageRecords() {
        return this.pageRecords;
    }

    @Override
    public void setPageRecords(List<T> pageRecords) {
        this.pageRecords = pageRecords;
        adjustPage();
    }

    @Override
    public List<T> getTotalRecords() {
        return this.totalRecords;
    }

    @Override
    public void setTotalRecords(List<T> totalRecords) {
        this.totalRecords = totalRecords;
        adjustPage();
    }

    @Override
    public int getRecordSize() {
        return this.pageRecords == null?0:this.pageRecords.size();
    }

    @Override
    public boolean isFirstPage() {
        return (this.pageNo == 1);
    }

    @Override
    public boolean isLastPage() {
        return (this.pageNo == this.pageCount);
    }

}
