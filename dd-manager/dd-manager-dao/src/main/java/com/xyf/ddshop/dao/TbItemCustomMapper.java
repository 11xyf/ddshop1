package com.xyf.ddshop.dao;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCustomMapper {

    int countItem();

    List<TbItemCustom> listItemByPage(@Param("page") Page page, @Param("order") Order order);
}