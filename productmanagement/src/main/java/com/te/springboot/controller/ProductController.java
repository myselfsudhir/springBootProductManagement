package com.te.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.beans.ProductResponse;
import com.te.springboot.beans.Products;
import com.te.springboot.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository pr;
	
	
	@PostMapping(path = "/addProduct", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Products addProduct(@RequestBody Products infoBean) {
		
		return pr.save(infoBean);
	}
	
	
	@PutMapping(path = "/updateProduct", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse updateProduct(@RequestBody Products product) {
		ProductResponse response = new ProductResponse();
		Optional<Products> op  =pr.findById(product.getPid());
		Products bean = null;
		if(op.isPresent()) {
			bean = pr.save(product);
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("updated successfully");
			response.setProduct(bean);
		}else {
			response.setStatusCode(400);
			response.setMsg("failed");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/deleteProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse deleteProduct(int pid) {
		ProductResponse resp = new ProductResponse();
		Optional<Products> op = pr.findById(pid);
		if(op.isPresent()) {
			pr.deleteById(pid);
			resp.setStatusCode(200);
			resp.setMsg("success");
			resp.setDescription("deleted successfully");
		}else {
			resp.setStatusCode(400);
			resp.setMsg("failed");
		}
		
		return resp;
	}
	
	
	
}
