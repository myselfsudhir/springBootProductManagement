package com.te.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springboot.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{
	@Query("from employee_info where id=:id and password =:password")
	public EmployeeInfoBean authenticate(int id,String password);

}
