package com.te.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.te.springboot.beans.Products;

public interface ProductRepository extends CrudRepository<Products,Integer>{

}
