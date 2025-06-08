package com.adi.library.pojos;


public class BookRequest {
    private String name;
    private String author;
    private int stock;
    private double price;
    
    
	public BookRequest(String name, String author, int stock, double price) {
		super();
		this.name = name;
		this.author = author;
		this.stock = stock;
		this.price = price;
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
		return "BookRequest [name=" + name + ", author=" + author + ", stock=" + stock + ", price=" + price + "]";
	}

    
}

