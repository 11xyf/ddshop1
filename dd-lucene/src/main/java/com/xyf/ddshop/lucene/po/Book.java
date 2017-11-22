package com.xyf.ddshop.lucene.po;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 10:51
 * Version:V1.0
 */
public class Book {
    //图片ID，主键
    private Integer id;
    //图书名称
    private String name;
    //图书价格
    private Float price;
    //图书图片
    private String pic;
    //图书描述
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
