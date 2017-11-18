package com.xyf.ddshop.service.impl;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.dao.TbItemParamCustomMapper;
import com.xyf.ddshop.dao.TbItemParamMapper;
import com.xyf.ddshop.pojo.po.TbItemParam;
import com.xyf.ddshop.pojo.po.TbItemParamExample;
import com.xyf.ddshop.pojo.vo.TbItemParamCustom;
import com.xyf.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 9:10
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemParamCustomMapper tbItemParamCustomMapper;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page, Order order) {
        Result<TbItemParamCustom> rs = new Result<>();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("page", page);
            map.put("order",order);
            int i = tbItemParamCustomMapper.countItemParams();
            List<TbItemParamCustom> list = tbItemParamCustomMapper.listItemParamsByPage(map);
            rs.setTotal(i);
            rs.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int saveItemParamsByCid(Long cid,String paramData) {
        int i=0;
        try {
            TbItemParam record = new TbItemParam();
            record.setItemCatId(cid);
            record.setParamData(paramData);
            record.setCreated(new Date());
            record.setUpdated(new Date());
            i=tbItemParamMapper.insert(record);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public TbItemParam getItemParamsByCid(Long cid) {
        TbItemParam tbItemParam=null;
        try {
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
            if (list!=null && list.size()>0){
                tbItemParam=list.get(0);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
