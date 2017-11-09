package com.xyf.ddshop.web;

import com.xyf.ddshop.common.dto.Order;
import com.xyf.ddshop.common.dto.Page;
import com.xyf.ddshop.common.dto.Result;
import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.pojo.vo.TbItemCustom;
import com.xyf.ddshop.pojo.vo.TbItemQuery;
import com.xyf.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:01
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(@PathVariable(value = "itemId") Long itemId) {
        System.out.println(itemId);
        return itemService.getById(itemId);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        //System.out.println(page);
        return page;
    }

    /*   @RequestMapping("/items")
       @ResponseBody
       public List<TbItem> listItems(){

           return itemService.getListItems();
       }*/
    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery tbItemQuery) {
        return itemService.listItemsByPage(page, order,tbItemQuery);
    }

    @ResponseBody
    @RequestMapping("items/batchRemove")
    public int removeUpdateItemsByIds(@RequestParam("ids[]") List<Long> ids) {
        return itemService.removeUpdateItemsByIds(ids);
    }

    @ResponseBody
    @RequestMapping("items/batchUp")
    public int upUpdateItemsByIds(@RequestParam("ids[]") List<Long> ids) {
        return itemService.upUpdateItemsByIds(ids);
    }

    @ResponseBody
    @RequestMapping("items/batchDown")
    public int downUpdateItemsByIds(@RequestParam("ids[]") List<Long> ids) {
        return itemService.downUpdateItemsByIds(ids);
    }
}
