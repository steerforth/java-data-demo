package com.steer.demo.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-10 17:32
 */
public class GoodDto {

    private float cost;

    private String image;

    private float price;
    @JSONField(name = "product_id")
    private String productId;

    private int sales;

    private int stock;

    private String suk;

    private String unique;

    public GoodDto(float cost, String image, float price, String productId, int sales, int stock, String suk, String unique) {
        this.cost = cost;
        this.image = image;
        this.price = price;
        this.productId = productId;
        this.sales = sales;
        this.stock = stock;
        this.suk = suk;
        this.unique = unique;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSuk() {
        return suk;
    }

    public void setSuk(String suk) {
        this.suk = suk;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }
}
