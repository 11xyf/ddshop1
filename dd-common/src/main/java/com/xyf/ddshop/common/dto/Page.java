package com.xyf.ddshop.common.dto;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 16:58
 * Version:V1.0
 */
public class Page {
    private int page;
    private int rows;
    //private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page - 1) * rows;
    }

}
