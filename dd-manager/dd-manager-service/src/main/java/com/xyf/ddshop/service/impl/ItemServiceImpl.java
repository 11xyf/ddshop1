package com.xyf.ddshop.service.impl;

import com.sun.tools.hat.internal.util.ArraySorter;
import com.xyf.ddshop.dao.TbItemMapper;
import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:21
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        //System.out.println(tbItem);
        return tbItem;
    }

    @Override
    public List<TbItem> getListItems() {
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);
        //System.out.println(tbItems);
        return tbItems;
    }
}
