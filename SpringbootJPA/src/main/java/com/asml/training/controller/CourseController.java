package com.asml.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.asml.training.model.Course;
import com.asml.training.service.CourseService;


@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.get();
	}
	
	@GetMapping("/course/{id}")
    public List<Course> getByDays (@PathVariable(value="id") Integer id)
    {
        return courseService.findById(id);
    }
	
	@PostMapping("/course")
	public void add(@RequestBody Course course) {
		courseService.add(course);
	}
	
	@GetMapping("/between")
    public List<Course> getByCoursePrice(Integer price)
    {
  	  return courseService.findByCoursePrice(price);
    }
}