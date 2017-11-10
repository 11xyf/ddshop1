package com.xyf.ddshop.web;

import com.xyf.ddshop.common.dto.TreeNode;
import com.xyf.ddshop.service.ItemCatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 17:55
 * Version:V1.0
 */
@Controller
public class ItemCatsAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemCatsService itemCatsService;

    @ResponseBody
    @RequestMapping("/itemCats")
    public List<TreeNode> listItemCats(@RequestParam("parentId") Long parentId) {
        List<TreeNode> list = null;
        try {
            list = itemCatsService.listItemCats(parentId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }
}
