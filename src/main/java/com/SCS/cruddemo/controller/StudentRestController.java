package com.SCS.cruddemo.controller;

import com.SCS.cruddemo.entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

private List<Student>students;

@PostConstruct
public void loadData(){
  students.add(new Student("Devi","PS"));
  students.add(new Student("Arathy","Yadu"));
  students.add(new Student("Daya","VV"));
  students.add(new Student("Uday","SS"));
}

  @GetMapping("/students")
  public List<Student> getStudents(){

    return students;
  }

  @GetMapping("/students/{studentID}")
  public Student getStudent(@PathVariable Integer studentID){

    return  students.get(studentID);
  }
}
