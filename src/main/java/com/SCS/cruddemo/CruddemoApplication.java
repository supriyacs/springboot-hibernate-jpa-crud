package com.SCS.cruddemo;

import com.SCS.cruddemo.dao.StudentDAO;
import com.SCS.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int rowsDeleted= studentDAO.deleteAll();
		System.out.println(" No: of students deleted= "+rowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(4);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		Student student=studentDAO.findByID(studentId);
		System.out.println("Exixting Student:"+student);
		student.setFirstName("Radha");
		studentDAO.update(student);
		System.out.println("Updated Student: "+student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> studentList=studentDAO.findByLastName("PP");
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student>students=studentDAO.findAll();
		for(Student student:students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student....");
		Student student=new Student("Ravi","PP","ravi@gmail.com");
		System.out.println("save the student");
		studentDAO.Save(student);
		int id= student.getId();
		System.out.println(" saved student- generated id: "+id);

		Student myStudent=studentDAO.findByID(id);
		System.out.println("Found Student : "+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating Multiple Students....");
		Student student1=new Student("Radha","AA","radha@gmail.com");
		Student student2=new Student("Hema","BB","Hema@gmail.com");
		Student student3=new Student("Riya","CC","Riya@gmail.com");
		System.out.println("Saving  Students....");
		studentDAO.Save(student1);
		studentDAO.Save(student2);
		studentDAO.Save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student....");
		Student student=new Student("Rekha","PV","rekha@gmail.com");
		System.out.println("Saving new Student....");
		studentDAO.Save(student);
		System.out.println("Generated Student ID: "+student.getId());
	}
}
