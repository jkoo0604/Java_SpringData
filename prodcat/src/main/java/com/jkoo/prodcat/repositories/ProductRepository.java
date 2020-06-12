package com.jkoo.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkoo.prodcat.models.Category;
import com.jkoo.prodcat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNull();
	List<Product> findByCategoriesContains(Category category);
	List<Product> findByCategoriesNotContaining(Category category);
}
