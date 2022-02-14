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
import com.asml.training.model.Trainer;
import com.asml.training.service.TrainerService;

@RestController
public class TrainerController {
	
	@Autowired
	TrainerService trainerService;
	
	@GetMapping("/trainers")
	public List<Trainer> getAllTrainers(){
		
		return trainerService.get();
	}
	
	@GetMapping("/trainer/{email}")
    public List<Trainer> getByName (@PathVariable(value="email") String email)
    {
        return trainerService.getByEmail(email);
    }
	
	@PostMapping("/trainer")
	public void add(@RequestBody Trainer trainer) {
		trainerService.add(trainer);
	}

}