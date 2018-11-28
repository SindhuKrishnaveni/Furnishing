package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	int categoryid;
	String categoryname;
	String categorydescp;
	@OneToMany(mappedBy="category")  //category refers to property name in Product 
	 private List<Product> products;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydescp() {
		return categorydescp;
	}
	public void setCategorydescp(String categorydescp) {
		this.categorydescp = categorydescp;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
