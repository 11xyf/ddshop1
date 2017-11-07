package com.xyf.ddshop.service;

import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:17
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);
  //  List<TbItem> getListItems();
    Result<TbItem> listItemsByPage(Page page);
}