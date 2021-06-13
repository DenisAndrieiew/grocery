package com.goit.grocery.model.entity;

import java.math.BigDecimal;

public class Product {
    char id;
    BigDecimal price;
    int actionCount;
    BigDecimal actionPrice;

    public Product(char id, BigDecimal price, int actionCount, BigDecimal actionPrice) {
        this.id = id;
        this.price = price;
        this.actionCount = actionCount;
        this.actionPrice = actionPrice;
    }

    public Product(char id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
    public Product(char id, double price, int actionCount, double actionPrice) {
        this.id = id;
        this.price = new BigDecimal(price);
        this.actionCount = actionCount;
        this.actionPrice =new BigDecimal(actionPrice);
    }
    public Product(char id, double price) {
        this.id = id;
        this.price =new BigDecimal(price);
    }
    public char getId() {
        return id;
    }

//    public void setId(char id) {
//        this.id = id;
//    }

    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }

    public int getActionCount() {
        return actionCount;
    }

//    public void setActionCount(int actionCount) {
//        this.actionCount = actionCount;
//    }

    public BigDecimal getActionPrice() {
        return actionPrice;
    }

//    public void setActionPrice(BigDecimal actionPrice) {
//        this.actionPrice = actionPrice;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.getId() +
                ", price=" + this.getPrice() +
                ", actionCount=" + this.getActionCount() +
                ", actionPrice=" + this.getActionPrice() +
                '}';
    }
}
