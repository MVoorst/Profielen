package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class ProfielenService {
	
	@Autowired
	private ProfielenRepository werkervaringRepository;

	public Werkervaring save(Werkervaring werkervaring){
		return werkervaringRepository.save(werkervaring);
	}

	public Optional<Werkervaring> findById(Long id) {
		return werkervaringRepository.findById(id);
	}
	
	public Iterable <Werkervaring> findAll(){
		Iterable <Werkervaring> result = werkervaringRepository.findAll();
		return result;
	}
}
