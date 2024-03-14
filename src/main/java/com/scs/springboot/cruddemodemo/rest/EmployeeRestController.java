package com.scs.springboot.cruddemodemo.rest;

import com.scs.springboot.cruddemodemo.dao.EmployeeDAO;
import com.scs.springboot.cruddemodemo.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  @Autowired
  private EmployeeDAO employeeDAO;
  @GetMapping("/employees")
  public List<Employee>listEmployee(){

    return employeeDAO.findAll();
  }
}
