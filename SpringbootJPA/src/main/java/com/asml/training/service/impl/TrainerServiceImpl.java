package com.asml.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asml.training.model.Trainer;
import com.asml.training.repository.impl.TrainerDaoImpl;
import com.asml.training.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	TrainerDaoImpl trainerDaoImpl;

	@Override
	public List<Trainer> get() {
		return trainerDaoImpl.getAll();
	}

	@Override
	public void add(Trainer trainer) {
		trainerDaoImpl.add(trainer);
		
	}

	@Override
	public List<Trainer> getByEmail(String email) {
		
		return trainerDaoImpl.getByEmail(email);
	}

	
	
}