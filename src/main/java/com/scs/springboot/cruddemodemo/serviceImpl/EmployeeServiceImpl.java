package com.scs.springboot.cruddemodemo.serviceImpl;

import com.scs.springboot.cruddemodemo.dao.EmployeeDAO;
import com.scs.springboot.cruddemodemo.entity.Employee;
import com.scs.springboot.cruddemodemo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO){
    this.employeeDAO=employeeDAO;
  }
  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findByID(int id) {
    Employee employee=employeeDAO.findByID(id);
    return employee;
  }
}
