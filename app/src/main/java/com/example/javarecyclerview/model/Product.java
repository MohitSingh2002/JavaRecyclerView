package com.example.javarecyclerview.model;

import java.io.Serializable;

public class Product implements Serializable {

    public String name;
    public int quantity = 0, price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
