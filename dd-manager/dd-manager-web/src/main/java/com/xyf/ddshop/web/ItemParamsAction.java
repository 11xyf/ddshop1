package com.xyf.ddshop.web;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.pojo.po.TbItemParam;
import com.xyf.ddshop.pojo.vo.TbItemParamCustom;
import com.xyf.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 21:13
 * Version:V1.0
 */
@Controller
public class ItemParamsAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParamsByPage(Page page, Order order) {
        Result<TbItemParamCustom> result = new Result<TbItemParamCustom>();
        try {
            result = itemParamService.listItemParamsByPage(page,order);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/itemParams/save/{cid}")
    public int saveItemParams(@PathVariable("cid") Long cid,String paramData){
        int i=0;
        try {
            i=itemParamService.saveItemParamsByCid(cid,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    @ResponseBody
    @RequestMapping("/itemParam/query/{cid}")
    public TbItemParam getItemParamsByCid(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam=null;
        try {
            tbItemParam=itemParamService.getItemParamsByCid(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
