package com.asml.training.service;

import java.util.List;

import com.asml.training.model.Trainer;
import com.asml.training.model.TrainingEvent;

public interface TrainingEventService {
	List<TrainingEvent> get();

	 public void add(TrainingEvent event);
	 List<TrainingEvent> getByEventId(Integer eventId);

}