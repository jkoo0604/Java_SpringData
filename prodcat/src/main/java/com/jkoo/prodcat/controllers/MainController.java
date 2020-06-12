package com.jkoo.prodcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jkoo.prodcat.models.Category;
import com.jkoo.prodcat.models.Product;
import com.jkoo.prodcat.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/prodcat")
	public String index(Model model) {
		List<Product> allprod = mainService.allProducts();
		List<Category> allcat = mainService.allCategories();
		model.addAttribute("products", allprod);
		model.addAttribute("categories", allcat);
		return "/prodcat/index.jsp";
    }
	
	@RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {		
        return "/products/new.jsp";
    }
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {		
		return "/categories/new.jsp";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
    public String createProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/products/new.jsp";
        } else {
        	Product newp = mainService.createProduct(product);
            return "redirect:/products/" + newp.getId();
        }
    }
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
    public String createCat(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/categories/new.jsp";
        } else {
        	Category newc = mainService.createCategory(category);
            return "redirect:/categories/" + newc.getId();
        }
    }
	
	@RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long productID, Model model) {
    	Product product = mainService.findProduct(productID);
    	if (product == null) {
    		return "redirect:/prodcat";
    	}
    	List<Category> addcat = mainService.allCategoriesNotProd(productID);
    	model.addAttribute("product", product);
    	model.addAttribute("addcats", addcat);
    	return "/products/show.jsp";
    }
	
	@RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long categoryID, Model model) {
    	Category category = mainService.findCategory(categoryID);
    	if (category == null) {
    		return "redirect:/prodcat";
    	}
    	List<Product> addprod = mainService.allProductsNotCat(categoryID);
    	model.addAttribute("category", category);
    	model.addAttribute("addprods", addprod);
    	return "/categories/show.jsp";
    }
	
	@RequestMapping(value="/products/{id}/add", method=RequestMethod.PUT)
    public String addCat(@PathVariable("id") Long productID, @RequestParam("categoryID") Long categoryID, Model model) {
    		Product updateprod = mainService.addCategory(productID, categoryID);
    		if (updateprod == null) {
    			return "redirect:/prodcat";
    		}
    		return "redirect:/products/" + updateprod.getId();
    }
	
	@RequestMapping(value="/categories/{id}/add", method=RequestMethod.PUT)
    public String addProd(@PathVariable("id") Long categoryID, @RequestParam("productID") Long productID, Model model) {
    		Category updatecat = mainService.addProduct(categoryID, productID);
    		if (updatecat == null) {
    			return "redirect:/prodcat";
    		}
    		return "redirect:/categories/" + updatecat.getId();
    }

	
}
