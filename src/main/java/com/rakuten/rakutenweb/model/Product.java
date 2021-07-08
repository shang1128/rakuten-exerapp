package com.rakuten.rakutenweb.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    public Product() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 45)
    private String brand;

    @Column(name="discount_price", nullable = false)
    private float discountPrice;

    @Column(nullable = false)
    private float price;

    @Override
    public String toString(){
        return String.format("id=%d, name='%s', brand='%s', discountPrice=%d, price=%d",
                id, name, brand, discountPrice, price);
    }

    public Product(Long id, String name, String brand, float discountPrice, float price) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.discountPrice = discountPrice;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
