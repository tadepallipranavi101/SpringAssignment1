package com.example.demo.Service;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.Model.Student;

@Service
public class StudentService implements InitializingBean, DisposableBean{

	private Map<Integer,Student> studentMap;
	private Logger logger = LoggerFactory.getLogger(StudentService.class);

	public StudentService() {
		super();
		studentMap = new HashMap<>();
	}
	
	//Add a new Student
	public void addStudent(Student student) {
		studentMap.put(student.getId(), student);
	}
	
	//Fetch all students
	public List<Student> getAllStudents(){
		return new ArrayList<>(studentMap.values());
	}
	
	//Fetch a student by ID
	public Student getStudentById(int id) {
		return studentMap.get(id);
	}
	
	//Update Student's score by ID
	public void updateStudentScoreById(int id, double newScore) {
		Student student = studentMap.get(id);
		if(student!=null) {
			double oldScore = student.getScore();
			student.setScore(newScore);
			studentMap.put(id, student);
		}
		
		//score <50
		if(newScore<50) {
			logger.info("Student with ID{} is Below Average (Score: {}", id, newScore);
		}else if(newScore>=50 && newScore<=75) {
			logger.info("Student with ID{} is Average (Score: {}", id, newScore);
		}else
		{
			logger.info("Student with ID{} is Above Average (Score: {}", id, newScore);
		}
	}
	
	//Delete Student by ID
	public void deleteStudentById(int id) {
		studentMap.remove(id);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("StudentService has been Initialized.");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("StudentService has been Destroyed.");
	}
}
