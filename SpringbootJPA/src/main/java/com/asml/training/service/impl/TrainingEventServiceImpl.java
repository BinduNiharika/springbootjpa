package com.asml.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.asml.training.model.TrainingEvent;
import com.asml.training.repository.impl.TrainingEventDaoImpl;
import com.asml.training.service.TrainingEventService;

@Service
public class TrainingEventServiceImpl implements TrainingEventService{

	@Autowired
	TrainingEventDaoImpl trainingEventDaoImpl;
	@Override
	public List<TrainingEvent> get() {
		return trainingEventDaoImpl.getAll();
		
	}
	@Override
	public void add(TrainingEvent event) {
		trainingEventDaoImpl.add(event);
	}
	@Override
	public List<TrainingEvent> getByEventId(Integer eventId) {
	return trainingEventDaoImpl.getByEventId(eventId);
	}

}