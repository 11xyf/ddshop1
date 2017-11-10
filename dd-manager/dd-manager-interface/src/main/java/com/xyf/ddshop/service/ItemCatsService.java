package com.xyf.ddshop.service;

import com.xyf.ddshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 19:27
 * Version:V1.0
 */
public interface ItemCatsService {
    List<TreeNode> listItemCats(Long parentId);
}
