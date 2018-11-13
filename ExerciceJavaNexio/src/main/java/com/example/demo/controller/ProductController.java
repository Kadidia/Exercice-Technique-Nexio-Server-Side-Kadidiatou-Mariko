package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

/* Controller handling HTTP requests*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		try {
			productRepo.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);	
	}
	
	/*return detail of a product as JSON format*/
	@RequestMapping(value="/productdetail/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProductDetailsbyId(@PathVariable Integer id) {
		Product product = new Product();
		
		try {
			Optional<Product> p = productRepo.findById(id);
			return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);	
	}
	/*return all products in data base */
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Product>> getProduts() {
		ArrayList<Product> empty = new ArrayList<Product>();
		try {
			ArrayList<Product> products = (ArrayList<Product>) productRepo.findAll();
			return new ResponseEntity<ArrayList<Product>>(products, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ArrayList<Product>>(empty, HttpStatus.OK);
	}
	
	/*return all products in cart */
	@RequestMapping(value="/products/cart", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Product>> getProdutsInCart() {
		ArrayList<Product> empty = new ArrayList<Product>();
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Product> productsCart = new ArrayList<Product>();
		
		try {
			products = (ArrayList<Product>) productRepo.findAll();
			for(Product p : products) {
				if(p.getCartFlag() == 1) productsCart.add(p);
			}
			if(products.size() != 0) 
			return new ResponseEntity<ArrayList<Product>>(productsCart, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ArrayList<Product>>(empty, HttpStatus.OK);
	}
	
	/*add a product in cart */
	@RequestMapping(value="/products/addtocart/{id}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> addProductToCart(@PathVariable Integer id) {
		Boolean isProductAddedToCart = false;
		
		try {
			Optional<Product> p = productRepo.findById(id);			
			p.get().setCartFlag(1);
			productRepo.save(p.get());
			isProductAddedToCart=true;			
			return new ResponseEntity<Boolean>(isProductAddedToCart, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Boolean>(isProductAddedToCart, HttpStatus.OK);
		}
	}
	
	/*delete a product from cart */
	@RequestMapping(value="/products/deletefromcart/{id}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> deleteFromCart(@PathVariable Integer id) {
		Boolean isProductDeletedFromCart = false;		
		try {
			Optional<Product> p = productRepo.findById(id);
			p.get().setCartFlag(0);
			productRepo.save(p.get());
			isProductDeletedFromCart=true;			
			return new ResponseEntity<Boolean>(isProductDeletedFromCart, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Boolean>(isProductDeletedFromCart, HttpStatus.OK);
		}
	}

}
