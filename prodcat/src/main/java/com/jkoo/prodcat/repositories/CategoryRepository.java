package com.jkoo.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkoo.prodcat.models.Category;
import com.jkoo.prodcat.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNull();
	List<Category> findByProductsContains(Product product);
	List<Category> findByProductsNotContaining(Product product);
}
