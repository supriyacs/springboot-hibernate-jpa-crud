package com.scs.springboot.cruddemodemo.dao;

import com.scs.springboot.cruddemodemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();
  Employee findByID(int id);

  Employee createEmployee(Employee employee);

  Employee updateEmployee(Employee employee);

  Employee deleteEmployeeById(int id);

}
