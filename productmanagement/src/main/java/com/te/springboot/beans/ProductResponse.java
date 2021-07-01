package com.te.springboot.beans;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@XmlRootElement(name="response")
@JsonRootName("productResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable{
	
	
	@XmlElement
	@JsonProperty
	private int statusCode;
	

	@XmlElement
	@JsonProperty
	private String msg;
	

	@XmlElement
	@JsonProperty
	private String description;
	
	@XmlElement
	@JsonProperty
	private Products product;
	
	@XmlElement
	@JsonProperty
	List<Products> products;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	

}
