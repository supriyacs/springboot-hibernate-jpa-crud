package com.scs.springboot.cruddemodemo.service;


import com.scs.springboot.cruddemodemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

 List<Employee> findAll();
 Employee findByID(int id);


}
