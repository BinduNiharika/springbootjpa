package com.asml.training.service;

import java.util.List;

import com.asml.training.model.Course;
import com.asml.training.model.Student;

public interface StudentService {
	List<Student> get();

	public void add(Student student);
	
	List<Student> findByName(String studentName);
	 List<Student> getStudentId(Integer  studentId);

}
