package com.asml.training.service;

import java.util.List;

import com.asml.training.model.Course;




public interface CourseService {
	List<Course> get();
	public void add(Course course);
	List<Course> findById(Integer courseId);
	List<Course> findByCoursePrice(Integer price);

}