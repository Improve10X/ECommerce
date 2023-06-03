package com.improve10x.ecommerce.cart;

import java.util.ArrayList;

public class CartProduct {

    private String id;
    private Integer userId;
    private String date;

    public ArrayList<ProductDetails> products;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
