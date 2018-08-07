package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class CVService {
	
	@Autowired
	private CVRepository cvRepository;

	public CV save(CV cv){
		return cvRepository.save(cv);
	}

	public Optional<CV> findById(Long id) {
		return cvRepository.findById(id);
	}
	public void delete(CV cv){
		cvRepository.delete(cv);
	}
	
	public Iterable <CV> findAll(){
		Iterable <CV> result = cvRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {
		
		return cvRepository.existsById(id);
	}


}