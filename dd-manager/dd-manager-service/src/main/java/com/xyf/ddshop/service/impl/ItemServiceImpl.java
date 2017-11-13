package com.xyf.ddshop.service.impl;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.common.util.IDUtils;
import com.xyf.ddshop.dao.TbItemCustomMapper;
import com.xyf.ddshop.dao.TbItemDescMapper;
import com.xyf.ddshop.dao.TbItemMapper;
import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.pojo.po.TbItemDesc;
import com.xyf.ddshop.pojo.po.TbItemExample;
import com.xyf.ddshop.pojo.vo.TbItemCustom;
import com.xyf.ddshop.pojo.vo.TbItemQuery;
import com.xyf.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:21
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemCustomMapper tbItemCustomMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        //System.out.println(tbItem);
        return tbItem;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery tbItemQuery) {
        Result<TbItemCustom> rs = new Result<>();
        int total = tbItemCustomMapper.countItem(tbItemQuery);
        List<TbItemCustom> list = tbItemCustomMapper.listItemByPage(page, order, tbItemQuery);
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

    @Override
    public int saveItemDesc(TbItem tbItem, String content) {
        int i=0;
        try {
            long id = IDUtils.getItemId();
            //tb_item表填充字段
            tbItem.setId(id);
            tbItem.setStatus((byte)2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i=tbItemMapper.insert(tbItem);
            //tb_item_desc表填充字段
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(id);
            tbItemDesc.setItemDesc(content);
            tbItemDesc.setCreated(new Date());
            tbItemDesc.setUpdated(new Date());
            i += tbItemDescMapper.insert(tbItemDesc);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    /*    @Override
    public List<TbItem> getListItems() {
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);
        //System.out.println(tbItems);
        return tbItems;
    }*/
}
