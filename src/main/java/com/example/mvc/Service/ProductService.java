package com.example.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.Model.Product;
import com.example.mvc.Repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository pr;
	
	public void insert(Product p) {
		pr.save(p);
	}
	
	public Product getProduct(int id) {
		return pr.getById(id);
	}
	
	public List<Product> getAllProducts(){
		List<Product> l=pr.findAll();
		for(Product p:l) {
			System.out.println(p);
		}
		return l;
	}
	
	public void delete(int id) {
		pr.deleteById(id);
	}
}
