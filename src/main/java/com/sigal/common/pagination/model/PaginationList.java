package com.sigal.common.pagination.model;

import java.util.List;

/**
 * 分页列表
 * @author LOMI
 *
 * @param <T>
 */
public interface PaginationList<T> extends java.io.Serializable {

    public static final int DEFAULT_PAGE_SIZE = 15;

    /**
     * 获取每页最大记录数
     *
     * @return
     */
    public int getPageSize();

    /**
     * 获取当前页号，从1开始
     *
     * @return
     */
    public int getPageNo();

    /**
     * 获取总页数
     *
     * @return
     */
    public int getPageCount();

    /**
     * 获取总记录数
     *
     * @return
     */
    public int getTotalSize();


    /**
     * 获取当前页记录数
     * @return
     */
    public int getRecordSize();

    /**
     * 获取当前页列表记录数据
     *
     * @return
     */
    public List<T> getPageRecords();

    /**
     * 获取列表总记录数据
     *
     * @return
     */
    public List<T> getTotalRecords();


    /**
     * 设置当前页列表记录数据
     */
    public void setPageRecords(List<T> pageRecords);

    /**
     * 设置列表总记录数据
     * @param totalRecords
     */
    public void setTotalRecords(List<T> totalRecords);

    /**
     * 当前页是不是第一页
     *
     * @return
     */
    public boolean isFirstPage();

    /**
     * 当前页是不是最后一页
     *
     * @return
     */
    public boolean isLastPage();

}
