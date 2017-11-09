package com.xyf.ddshop.service.impl;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.dao.TbItemCustomMapper;
import com.xyf.ddshop.dao.TbItemMapper;
import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.pojo.po.TbItemExample;
import com.xyf.ddshop.pojo.vo.TbItemCustom;
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
    @Autowired
    private TbItemCustomMapper tbItemCustomMapper;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        //System.out.println(tbItem);
        return tbItem;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order) {
        Result<TbItemCustom> rs = new Result<>();
        int total = tbItemCustomMapper.countItem();
        List<TbItemCustom> list = tbItemCustomMapper.listItemByPage(page, order);
        rs.setTotal(total);
        rs.setRows(list);
        return rs;
    }

    @Override
    public int removeUpdateItemsByIds(List<Long> ids) {
        TbItem record = new TbItem();
        record.setStatus((byte) 3);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int upUpdateItemsByIds(List<Long> ids) {
        TbItem record = new TbItem();
        record.setStatus((byte) 1);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int downUpdateItemsByIds(List<Long> ids) {
        TbItem record = new TbItem();
        record.setStatus((byte) 2);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(record, example);
    }
    /*    @Override
    public List<TbItem> getListItems() {
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);
        //System.out.println(tbItems);
        return tbItems;
    }*/
}
