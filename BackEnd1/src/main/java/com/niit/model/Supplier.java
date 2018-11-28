package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	int supplierid;
	String suppliername;
	String supplierdescp;
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierdescp() {
		return supplierdescp;
	}
	public void setSupplierdescp(String supplierdescp) {
		this.supplierdescp = supplierdescp;
	}
	

}
