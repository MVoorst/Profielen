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

	public Optional<Vragen> findById(Long id) {
		return vragenRepository.findById(id);
	}

	
	public void delete(Vragen vragen){
		vragenRepository.delete(vragen);
		}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		vragenRepository.deleteById(id);
	}
<<<<<<< HEAD
		
=======
>>>>>>> master
	public Iterable <Vragen> findAll(){
		Iterable <Vragen> result = vragenRepository.findAll();
		return result;
	}
<<<<<<< HEAD
	
	public boolean existsById(Long id) {
		
=======

	public boolean existsById(Long id) {
>>>>>>> master
		return vragenRepository.existsById(id);
	}
}
