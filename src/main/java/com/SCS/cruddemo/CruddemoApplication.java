package com.SCS.cruddemo;

import com.SCS.cruddemo.dao.StudentDAO;
import com.SCS.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
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
