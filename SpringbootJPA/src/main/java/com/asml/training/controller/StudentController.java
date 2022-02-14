package com.asml.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.training.model.Course;
import com.asml.training.model.Student;
import com.asml.training.service.StudentService;

@RestController
public class StudentController {
      @Autowired
	StudentService studentService;
      @GetMapping("/students")
      public List<Student> getAllStudents(){
    	  return studentService.get();
      }
      
      @GetMapping("/student/{name}")
      public List<Student> getByName (@PathVariable(value="name") String name)
      {
          return studentService.findByName(name);
      }
      
      @GetMapping("/studentid")
      public List<Student> getById (Integer id)
      {
          return studentService.getStudentId(id);
      }
      
      @PostMapping("/student")
  	public void add(@RequestBody Student student) {
  		studentService.add(student);
  	}
}