package com.practice.ssm.model;

public class Book {
    private Integer book_id;

    private String book_name;

    private Float price;

    public Book(Integer book_id, String book_name, Float price) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.price = price;
    }

    public Book() {
        super();
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}