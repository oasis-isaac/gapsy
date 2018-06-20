package com.oasisaac.gapsytest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasisaac.gapsytest.exception.ResourceNotFoundException;
import com.oasisaac.gapsytest.model.Product;
import com.oasisaac.gapsytest.model.ProductValidRequest;
import com.oasisaac.gapsytest.repository.ProductRepository;

@RestController
@RequestMapping("/gapsy-api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	// Get All products
	@GetMapping("/products")
	public List<Product> getAllproducts() {
		return productRepository.findAll();
	}

	// Create a new product
	@PostMapping("/products")
	public Product createproduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	// Get a Single product
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
	}

	// Update a product
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody ProductValidRequest productDetails) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));
		product.setDescription(productDetails.getDescription());
		product.setModel(productDetails.getModel());
		Product updatedproduct = productRepository.save(product);
		return updatedproduct;
	}

	// Delete a product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteproduct(@PathVariable(value = "id") Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}
}
