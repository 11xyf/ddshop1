package com.xyf.ddshop.dao;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.pojo.vo.TbItemCustom;
import com.xyf.ddshop.pojo.vo.TbItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCustomMapper {

    int countItem(@Param("tbItemQuery") TbItemQuery tbItemQuery);

    List<TbItemCustom> listItemByPage(@Param("page") Page page, @Param("order") Order order, @Param("tbItemQuery") TbItemQuery tbItemQuery);
}