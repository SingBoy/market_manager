package com.sigal.common.pagination.component;


import com.sigal.common.pagination.component.AbstractPaginationComponent;
import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.pagination.tag.PaginationTag;

import java.io.IOException;
import java.io.Writer;

/**
 * 简单数字卷动型分页组件实现
 * @author LOMI
 *
 */
public class Number2PaginationComponent extends AbstractPaginationComponent {

    private static final int MAX_SHOW_PAGE_NUM = 11;

    public Number2PaginationComponent(PaginationTag pagerTag,
            PaginationList<?> paginatedList) {
        super(pagerTag, paginatedList);
    }

    @Override
    public void render(Writer writer) throws IOException {
        StringBuilder sb = new StringBuilder();
        String url = adjustUrl(paginationTag.getUrl());

        if(paginatedList != null && paginatedList.getPageCount() > 0) {
            int startPage = getStartPage();
            int endPage = getEndPage(startPage);
            sb.append("<div class=\"pagination pagination-colory text-center\"><ul>");
//            sb.append("<div class=\"pagination pagination-small pagination-colory text-center\"><ul>"); &laquo; &raquo;
      
            sb.append("<li class=\"").append(paginatedList.isFirstPage()?"disabled":"")
            .append("\"><a href=\"").append(paginatedList.isFirstPage()?"#":url + "currentPage=" + (paginatedList.getPageNo()-1) + "&pageSize=" + paginatedList.getPageSize()).append("\">上一页</a></li>");
            
            for(int i = startPage; i <= endPage; i++) {
            	sb.append("<li class=\"").append(i == paginatedList.getPageNo()?"active":"")
            		.append("\"><a href=\"").append(url).append("currentPage=").append(i).append("&pageSize=").append(paginatedList.getPageSize()).append("\">")
            		.append(i).append("</a></li>");
            }
            
            sb.append("<li class=\"").append(paginatedList.isLastPage()?"disabled":"")
            .append("\"><a href=\"").append(paginatedList.isLastPage()?"#":url + "currentPage=" + (paginatedList.getPageNo()+1) + "&pageSize=" + paginatedList.getPageSize()).append("\">下一页</a></li>");
            
            sb.append("</ul></div>");

            writer.write(sb.toString());
        }
    }


    protected int getStartPage() {
        int half = MAX_SHOW_PAGE_NUM / 2;
        int startPage = 1;
        if (paginatedList.getPageCount() > MAX_SHOW_PAGE_NUM) {
            int pos = paginatedList.getPageNo() - half;
            startPage = (pos > 1 ? pos : 1);
            pos = paginatedList.getPageCount() - MAX_SHOW_PAGE_NUM + 1;
            if(startPage > pos){
                startPage = pos;
            }
        }
        return startPage;
    }


    protected int getEndPage(int startPage) {
        int pageEnd;
        if(paginatedList.getPageCount() > MAX_SHOW_PAGE_NUM){
            pageEnd = startPage + MAX_SHOW_PAGE_NUM - 1;
        }else{
            pageEnd = paginatedList.getPageCount();
        }
        return pageEnd;
    }

}
