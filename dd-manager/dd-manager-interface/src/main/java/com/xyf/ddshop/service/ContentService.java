package com.xyf.ddshop.service;

import com.xyf.ddshop.pojo.po.TbContent;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 20:05
 * Version:V1.0
 */
public interface ContentService {
    List<TbContent> listContentsByCid(Long id);
}
