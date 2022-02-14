package com.asml.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.training.model.Course;
import com.asml.training.repository.impl.CourseDaoImpl;
import com.asml.training.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDaoImpl courseDaoImpl;

	@Override
	public List<Course> get() {
		return courseDaoImpl.getAll();
	}

	@Override
	public void add(Course course) {
		courseDaoImpl.add(course);
		
	}

	@Override
	public List<Course> findById(Integer courseId) {
		return courseDaoImpl.getById(courseId);
	}

	@Override
	public List<Course> findByCoursePrice(Integer price) {
		return courseDaoImpl.getAll();
	}

}