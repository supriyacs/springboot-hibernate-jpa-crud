package com.scs.springboot.cruddemodemo.rest;

import com.scs.springboot.cruddemodemo.entity.Employee;
import com.scs.springboot.cruddemodemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> listEmployee() {

    return employeeService.findAll();
  }

  @GetMapping("/employees/{id}")
  Employee getEmployeeByID(@PathVariable Integer id){
    return employeeService.findByID(id);
  }
}
