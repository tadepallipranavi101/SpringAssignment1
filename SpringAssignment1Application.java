package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

@SpringBootApplication
public class SpringAssignment1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAssignment1Application.class, args);
		
		StudentService studentService = context.getBean(StudentService.class);
		
		Student student1 = new Student(1,"Yamini",85.5);
		Student student2 = new Student(2,"Pavani",70.0);
		Student student3 = new Student(3,"Pranavi",55.6);
		Student student4 = new Student(4,"Sailaja",49.9);
		
		//add a few students
		studentService.addStudent(student1);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		studentService.addStudent(student4);
		
		//fetch and display students
		System.out.println("All Students:");
		studentService.getAllStudents().forEach(System.out::println);
		
		//Update scores
		studentService.updateStudentScoreById(2, 75.0);
		
		//delete a student
		studentService.deleteStudentById(4);
		
		//fetch students after updating
		System.out.println("\nStudents after updating:");
		studentService.getAllStudents().forEach(System.out::println);
		
		context.close();
		}
}
