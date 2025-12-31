package com.mtcoding.store;

public class Store {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;

    public Store(Integer id, String name, Integer price, Integer qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String toString() {
        return id+ ", " + name + ", "+ price + ", " + qty;
    }
}
