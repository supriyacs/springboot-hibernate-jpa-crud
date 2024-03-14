package com.scs.springboot.cruddemodemo.daoImpl;

import com.scs.springboot.cruddemodemo.dao.EmployeeDAO;
import com.scs.springboot.cruddemodemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {


  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager entityManager){
   this.entityManager=entityManager;
  }
  @Override
  public List<Employee> findAll() {

    TypedQuery<Employee>query= entityManager.createQuery("from Employee", Employee.class);
    List<Employee>employees=query.getResultList();
    return employees;
  }
}
