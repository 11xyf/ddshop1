package com.xyf.ddshop.web;

import com.xyf.ddshop.pojo.po.TbItem;
import com.xyf.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(@PathVariable(value = "itemId") Long itemId){
        System.out.println(itemId);
        return itemService.getById(itemId);
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        //System.out.println(page);
        return page;
    }
    @RequestMapping("/items")
    @ResponseBody
    public List<TbItem> listItems(){
        return itemService.getListItems();
    }
}
