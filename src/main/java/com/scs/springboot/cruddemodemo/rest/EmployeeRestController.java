package com.scs.springboot.cruddemodemo.rest;

import com.scs.springboot.cruddemodemo.entity.Employee;
import com.scs.springboot.cruddemodemo.exceptions.EmployeeNotFoundException;
import com.scs.springboot.cruddemodemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public Employee getEmployeeByID(@PathVariable Integer id) {
    if(employeeService.findByID(id)==null){
      throw new EmployeeNotFoundException("Employee not found with ID= "+id);
    }
    return employeeService.findByID(id);
  }

  @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
    employee.setId(0);
      Employee createdEmplyee=employeeService.createEmployee(employee);
      return createdEmplyee;
    }

    @PutMapping("/employees")
  public Employee updateEmplyee(@RequestBody Employee employee){
    Employee updatedEmployee=employeeService.createEmployee(employee);
    return  updatedEmployee;
    }

    @DeleteMapping("/employees/{id}")
  public String deleteEmployeeByID(@PathVariable int id){
    employeeService.deleteEmployeeID(id);
      return "Emplyee delete with ID= "+id;
    }



}
