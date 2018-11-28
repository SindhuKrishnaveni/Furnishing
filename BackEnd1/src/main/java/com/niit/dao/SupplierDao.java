package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao {
	public Supplier addSupplier(Supplier supplier);
	public List<Supplier>getAllSupplier();
	public void updateSupplier(Supplier supplier);
	public void deleteSupplier(int id);
	public Supplier selectSupplier(int id);


}
