package com.asml.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.training.model.Student;
import com.asml.training.repository.impl.StudentDaoImpl;
import com.asml.training.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;
	@Override
	public List<Student> get() {
		return studentDaoImpl.getAll();
	}
	
	@Override
	public void add(Student student) {
	studentDaoImpl.add(student);
	}

	@Override
	public List<Student> findByName(String studentName) {
		return studentDaoImpl.getByName(studentName);
	}

	@Override
	public List<Student> getStudentId(Integer studentId) {
		
		return studentDaoImpl.getStudentId(studentId);
	}

}