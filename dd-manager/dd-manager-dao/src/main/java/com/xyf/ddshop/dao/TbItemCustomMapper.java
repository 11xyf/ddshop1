package com.xyf.ddshop.dao;

import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.pojo.po.TbItem;

import java.util.List;

public interface TbItemCustomMapper {

    int countItem();
    List<TbItem> listItemByPage(Page page);
}