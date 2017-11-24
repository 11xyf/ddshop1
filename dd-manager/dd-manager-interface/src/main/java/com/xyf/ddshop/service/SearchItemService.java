package com.xyf.ddshop.service;

import com.xyf.ddshop.pojo.vo.TbSearchItemResult;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 16:31
 * Version:V1.0
 */
public interface SearchItemService {
    void importAllItems() throws SolrServerException, IOException;

    TbSearchItemResult search(String keyword, int page, int rows) throws Exception;
}
