package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class VragenService {
	
	@Autowired
	private VragenRepository vragenRepository;

	public Vragen save(Vragen vragen){
		return vragenRepository.save(vragen);
	}

	public Vragen findById(Long id) {
		return vragenRepository.findById(id).orElse(null);
	}
	public void delete(Vragen vragen){
		vragenRepository.delete(vragen);
		}
	
	public Iterable <Vragen> findAll(){
		Iterable <Vragen> result = vragenRepository.findAll();
		return result;
	}

	public boolean existsById(Long id) {
		return vragenRepository.existsById(id);
	}
}
