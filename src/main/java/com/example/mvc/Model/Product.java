package com.example.mvc.Model;

import javax.persistence.*;

@Entity
@Table(name="Product_Details")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int pid;
	private String product_name;
	private String brand_name;
	private float price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", product_name=" + product_name + ", brand_name=" + brand_name + ", price="
				+ price + "]";
	}
	
	
}
