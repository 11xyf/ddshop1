package com.xyf.ddshop.service.impl;

import com.xyf.ddshop.common.dto.TreeNode;
import com.xyf.ddshop.dao.TbItemCatMapper;
import com.xyf.ddshop.pojo.po.TbItemCat;
import com.xyf.ddshop.pojo.po.TbItemCatExample;
import com.xyf.ddshop.service.ItemCatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 19:27
 * Version:V1.0
 */
@Service
public class ItemCatsServiceImpl implements ItemCatsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        List<TreeNode> list = null;
        try {
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
            //要序列化成JSON的列表对象
            list = new ArrayList<>();
            //遍历原有列表生成新列表
            for (int i = 0; i < tbItemCats.size(); i++) {
                TbItemCat tbItemCat = tbItemCats.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(tbItemCat.getId());
                treeNode.setText(tbItemCat.getName());
                treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
                list.add(treeNode);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }
}
