package com.xyf.ddshop.pojo.vo;

import com.xyf.ddshop.pojo.po.TbItemParam;

import java.util.Date;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 22:00
 * Version:V1.0
 */
public class TbItemParamCustom extends TbItemParam {
    private String itemCatName;
    private Date createdView;

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }

    public Date getCreatedView() {
        return createdView;
    }

    public void setCreatedView(Date createdView) {
        this.createdView = createdView;
    }
}
