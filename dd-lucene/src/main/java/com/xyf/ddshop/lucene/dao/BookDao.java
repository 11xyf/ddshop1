package com.xyf.ddshop.lucene.dao;

import com.xyf.ddshop.lucene.po.Book;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 10:52
 * Version:V1.0
 */
public interface BookDao {

    List<Book> listBooks();
}
