package org.oracle.product_api.repository;

import java.util.List;

import org.oracle.product_api.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);

	List<Product> findByPriceGreaterThanEqual(double price);

	List<Product> findByStockBetween(int min, int max);

	//List<Product> findByPriceLesser(int amt);
	
}