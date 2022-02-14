package com.asml.training.service;

import java.util.List;

import com.asml.training.model.Trainer;

public interface TrainerService {
	List<Trainer> get();

	 public void add(Trainer trainer);

	List<Trainer> getByEmail(String email);

}