package com.example.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name ;
	@Column(nullable = false)
	private int repertory ;
	@Column(nullable = false)
	private double price ;
	
	
	
	public Product() {
		super();
	}
	public Product(String name, int repertory, double price) {
		super();
		this.name = name;
		this.repertory = repertory;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRepertory() {
		return repertory;
	}
	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", repertory=" + repertory + ", price=" + price + "]";
	}
	
	
	
}
