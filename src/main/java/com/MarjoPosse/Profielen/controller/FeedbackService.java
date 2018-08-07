package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	public Feedback save(Feedback feedback){
		return feedbackRepository.save(feedback);
	}

	public Optional<Feedback> findById(Long id) {
		return feedbackRepository.findById(id);
	}
	public void delete(Feedback feedback){
		feedbackRepository.delete(feedback);
		}
	
	public Iterable <Feedback> findAll(){
		Iterable <Feedback> result = feedbackRepository.findAll();
		return result;
	}

	public boolean existsById(Long id) {
		return false;
	}

	
}
