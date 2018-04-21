package net.sg.shoppingbackend.dao;

import java.util.List;

import net.sg.shoppingbackend.dto.Product;



public interface ProductDAO {
	Product get(int id);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business Methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategoryId(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
