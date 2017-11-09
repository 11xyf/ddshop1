package com.xyf.ddshop.service;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:17
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);

    //  List<TbItem> getListItems();
    Result<TbItemCustom> listItemsByPage(Page page, Order order);

    int removeUpdateItemsByIds(List<Long> ids);

    int upUpdateItemsByIds(List<Long> ids);

    int downUpdateItemsByIds(List<Long> ids);
}
