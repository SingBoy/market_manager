package com.singe.core.model;

import com.singe.common.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseModel {

    public static final String DESC_ORDER = " DESC ";
    public static final String ASC_ORDER = " ASC ";
    protected Integer pageSize = 20;
    protected Integer currentPage = 1;
    protected Integer totalCount = 0;
    protected List<String> orderByProperties;
    protected String keyword;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date endDate;

    protected Date createDate;
    protected Date modifyDate;

    public BaseModel(){}

    public BaseModel(Integer pageSize, Integer currentPage){
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    /**
     * pageSize
     *
     * @return  the pageSize
     *
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     *
     */
    public BaseModel setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * currentPage
     *
     * @return  the currentPage
     *
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     *
     */
    public BaseModel setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getStartIndex() {
        if(!this.totalCount.equals(0)){
            Double maxPageDouble=Math.ceil((double)this.totalCount/this.pageSize);
            int maxPage=maxPageDouble.intValue();
            currentPage=currentPage>maxPage?maxPage:currentPage;
        }
        return (currentPage - 1) * pageSize;
    }

    public String getReversedFiled() {
        StringBuffer buffer = new StringBuffer();
        boolean isFirst = true;
        for(String prop : this.orderByProperties){
            if(!isFirst){
                buffer.append(",");
            }
            if(prop.contains(DESC_ORDER)){
                buffer.append(prop.replaceAll(DESC_ORDER, ASC_ORDER));
            }else{
                buffer.append(prop.replaceAll(ASC_ORDER, DESC_ORDER));
            }
            isFirst = false;
        }
        return buffer.toString();
    }

    public String getOrderByFiled() {
        StringBuffer buffer = new StringBuffer();
        boolean isFirst = true;
        for(String prop : this.orderByProperties){
            if(!isFirst){
                buffer.append(",");
            }
            buffer.append(prop);
            isFirst = false;
        }
        return buffer.toString();
    }

    /**
     * appendListProp
     * @方法作用
     * 向buffer 中追加list的值生成 缓存key时候使用
     *
     * @param buffer
     *
     * void
     * @exception
     */
    @SuppressWarnings("rawtypes")
    protected void appendListProp(List list, String sign, StringBuffer buffer) {
        if(list == null || list.isEmpty()){
            buffer.append(sign);
        }else{
            for(Object obj : list){
                buffer.append(obj.toString());
            }
        }
    }

    /**
     * totalCount
     *
     * @return  the totalCount
     *
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     *
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BaseModel addDescProperty(String property){
        if(orderByProperties == null){
            orderByProperties = new ArrayList<String>();
        }
        orderByProperties.add(property + DESC_ORDER);
        return this;
    }

    public BaseModel addAscProperty(String property){
        if(orderByProperties == null){
            orderByProperties = new ArrayList<String>();
        }
        orderByProperties.add(property + ASC_ORDER);
        return this;
    }

    public Integer getEndIndex() {
        Integer curEnd = this.pageSize * this.currentPage;
        if(totalCount == 0){
            return curEnd;
        }
        return curEnd > totalCount ? totalCount : curEnd;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
     /*   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        if(!StringUtils.isEmpty(df.format(startDate))){
            formatDate = java.sql.Date.valueOf(df.format(startDate));
        }*/
        this.startDate = DateUtils.CTStoDate(startDate);
    }

    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(Date endDate) {
    /*    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        if(!StringUtils.isEmpty(df.format(endDate))){
            formatDate = java.sql.Date.valueOf(df.format(endDate));
        }*/
        this.endDate = DateUtils.CTStoDate(endDate);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}