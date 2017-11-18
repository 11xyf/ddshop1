package com.xyf.ddshop.service;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.pojo.po.TbItemParam;
import com.xyf.ddshop.pojo.vo.TbItemParamCustom;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 9:06
 * Version:V1.0
 */
public interface ItemParamService {

    Result<TbItemParamCustom> listItemParamsByPage(Page page, Order order);

    int saveItemParamsByCid(Long cid,String paramData);

    TbItemParam getItemParamsByCid(Long cid);
}
