package com.himanshu.batchTest.entity;

public class Product {
    private int productId;
    private String title;
    private String description;
    private String discount;
    private String price;
    private String discountedPrice;


    public Product() {
    }


    public Product(String discountedPrice, int productId, String title, String description, String price, String discount) {
        this.discountedPrice = discountedPrice;
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
