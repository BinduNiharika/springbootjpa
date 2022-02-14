package com.asml.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asml.training.model.Course;
import com.asml.training.model.TrainingEvent;
import com.asml.training.service.TrainingEventService;

@RestController
public class TrainingEventController {
	
	@Autowired
	TrainingEventService trainingEventService;
	
	@GetMapping("/events")
	public List<TrainingEvent> getAllEvents(){
		return trainingEventService.get();
	}
	
	@PostMapping("/event")
	public void add(@RequestBody TrainingEvent event) {
		trainingEventService.add(event);
	}

}