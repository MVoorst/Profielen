package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Feedback;

@Component
public interface FeedbackRepository extends CrudRepository<Feedback, Long>{
	}

