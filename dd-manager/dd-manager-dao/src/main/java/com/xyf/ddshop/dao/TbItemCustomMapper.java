package com.xyf.ddshop.dao;

import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {

    int countItem();

    List<TbItemCustom> listItemByPage(Page page);
}