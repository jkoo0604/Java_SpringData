package com.jkoo.prodcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.prodcat.models.Category;
import com.jkoo.prodcat.models.Product;
import com.jkoo.prodcat.repositories.CategoryRepository;
import com.jkoo.prodcat.repositories.ProductRepository;

@Service
public class MainService {
	private final ProductRepository prodRepo;
	private final CategoryRepository catRepo;
	
	public MainService(ProductRepository prodRepo, CategoryRepository catRepo) {
		this.prodRepo = prodRepo;
		this.catRepo = catRepo;
	}
	
	public List<Product> allProducts() {
		return prodRepo.findAll();
	}
	
	public List<Product> productsNoCat() {
		return prodRepo.findByCategoriesNull();
	}
	
	public List<Product> allProductsCat(Long categoryID) {
		Optional<Category> checkcat = catRepo.findById(categoryID);
		if (checkcat.isPresent()) {
			Category category = checkcat.get();
			return prodRepo.findByCategoriesContains(category);
		}
		return null;
	}
	
	public List<Product> allProductsNotCat(Long categoryID) {
		Optional<Category> checkcat = catRepo.findById(categoryID);
		if (checkcat.isPresent()) {
			Category category = checkcat.get();
			return prodRepo.findByCategoriesNotContaining(category);
		}
		return null;
	}
	
	public Product findProduct(Long id) {
		Optional<Product> checkprod = prodRepo.findById(id);
		if (checkprod.isPresent()) {
			Product product = checkprod.get();
			return product;
		}
		return null;
	}
	
	public Product createProduct(Product p) {
		return prodRepo.save(p);
	}
	
	public Product addCategory(Long productID, Long categoryID) {
		Optional<Product> checkprod = prodRepo.findById(productID);
		Optional<Category> checkcat = catRepo.findById(categoryID);
		if (checkprod.isPresent() && checkcat.isPresent()) {
			Product product = checkprod.get();
			Category category = checkcat.get();
			product.getCategories().add(category);
			prodRepo.save(product);
			return product;
		}
		return null;
	}
	
	public List<Category> allCategories() {
		return catRepo.findAll();
	}
	
	public List<Category> categoriesNoProd() {
		return catRepo.findByProductsNull();
	}
	
	public List<Category> allCategoriesProd(Long productID) {
		Optional<Product> checkprod = prodRepo.findById(productID);
		if (checkprod.isPresent()) {
			Product product = checkprod.get();
			return catRepo.findByProductsContains(product);
		}
		return null;
	}
	
	public List<Category> allCategoriesNotProd(Long productID) {
		Optional<Product> checkprod = prodRepo.findById(productID);
		if (checkprod.isPresent()) {
			Product product = checkprod.get();
			return catRepo.findByProductsNotContaining(product);
		}
		return null;
	}
	
	public Category findCategory(Long id) {
		Optional<Category> checkcat = catRepo.findById(id);
		if (checkcat.isPresent()) {
			Category category = checkcat.get();
			return category;
		}
		return null;
	}
	
	public Category createCategory(Category c) {
		return catRepo.save(c);
	}
	
	public Category addProduct(Long categoryID, Long productID) {
		Optional<Category> checkcat = catRepo.findById(categoryID);
		Optional<Product> checkprod = prodRepo.findById(productID);
		if (checkprod.isPresent() && checkcat.isPresent()) {
			Category category = checkcat.get();
			Product product = checkprod.get();
			category.getProducts().add(product);
			catRepo.save(category);
			return category;
		}
		return null;
	}
	
	
}
