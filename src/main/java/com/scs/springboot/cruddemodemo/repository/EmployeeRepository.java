package com.scs.springboot.cruddemodemo.repository;

import com.scs.springboot.cruddemodemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



}
