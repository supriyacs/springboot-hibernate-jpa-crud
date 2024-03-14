package com.SCS.cruddemo.controller;

import com.SCS.cruddemo.entity.Student;
import com.SCS.cruddemo.errors.StudentErrorResponse;
import com.SCS.cruddemo.errors.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
  students = new ArrayList<>();
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
  if(studentID>=students.size()||studentID<0){
   throw new StudentNotFoundException("Student not found with ID-"+studentID);
  }
  return  students.get(studentID);
  }


  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException  e){
    StudentErrorResponse response=new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
  return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(Exception  e){
    StudentErrorResponse response=new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }
}
