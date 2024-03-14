package com.scs.springboot.cruddemodemo.serviceImpl;

import com.scs.springboot.cruddemodemo.entity.Employee;
import com.scs.springboot.cruddemodemo.repository.EmployeeRepository;
import com.scs.springboot.cruddemodemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository){
    this.employeeRepository=employeeRepository;
  }
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findByID(int id) {
    Employee employee=employeeRepository.findById(id).orElse(null);
    return employee;
  }

  @Override
  public Employee createEmployee(Employee employee) {
    Employee updatedEmployee=employeeRepository.save(employee);
    return updatedEmployee;
  }

  @Override
  public void deleteEmployeeID(int id) {
    employeeRepository.deleteById(id);
  }
}
