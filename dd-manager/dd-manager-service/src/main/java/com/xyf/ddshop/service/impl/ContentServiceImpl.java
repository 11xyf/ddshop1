package com.xyf.ddshop.service.impl;

import com.xyf.ddshop.common.jedis.JedisClient;
import com.xyf.ddshop.common.util.JsonUtils;
import com.xyf.ddshop.dao.TbContentMapper;
import com.xyf.ddshop.pojo.po.TbContent;
import com.xyf.ddshop.pojo.po.TbContentExample;
import com.xyf.ddshop.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 20:05
 * Version:V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Override
    public List<TbContent> listContentsByCid(Long id) {
        List<TbContent> list=null;
        //查询缓存，如果存在直接加载
        try {
            String hget = jedisClient.hget("CONTENT_LIST", id + "");
            if(StringUtils.isNotBlank(hget)){
                return JsonUtils.jsonToList(hget, TbContent.class);
            }
        }catch (Exception e){

            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        //如果缓存中没有
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        list = tbContentMapper.selectByExample(example);
        //将查询出的数据存放到缓存中
        try {

            jedisClient.hset("CONTENT_LIST", id + "", JsonUtils.objectToJson(list));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
