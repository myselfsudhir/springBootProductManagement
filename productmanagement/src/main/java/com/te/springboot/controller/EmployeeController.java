package com.te.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.beans.EmployeeInfoBean;
import com.te.springboot.beans.EmployeeResponse;
import com.te.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	
	@GetMapping(path = "/getEmp",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse authenticate(int id,String password) {
		
		EmployeeInfoBean op = repo.authenticate(id, password);
		
		EmployeeResponse response = new EmployeeResponse();
		
		if(op!=null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Employee Details found For " + id);
			response.setEmployeeInfoBean(op);
		} else {
			response.setStatusCode(403);
			response.setMessage("Failed");
			response.setDescription("Employee Details found For ID " + id + " Not Found");
		}
		return response;
	}
}
