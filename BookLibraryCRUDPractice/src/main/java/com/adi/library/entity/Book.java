package com.adi.library.entity;

public class Book {
    private Long id;
    private String name;
    private String author;
    private int stock;
    private double price;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(Long id, String name, String author, int stock, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }

    // Getters and setters

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}

