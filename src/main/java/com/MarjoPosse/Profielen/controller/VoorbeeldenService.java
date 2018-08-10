package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional

public class VoorbeeldenService {
	
	@Autowired
	private VoorbeeldenRepository voorbeeldenRepository;
		
	
	public Voorbeelden save(Voorbeelden voorbeeld){
		return voorbeeldenRepository.save(voorbeeld);
	}
	
	public Optional<Voorbeelden> findById(Long id) {
		return voorbeeldenRepository.findById(id);
	}
	public void delete(Voorbeelden voorbeeld){
		voorbeeldenRepository.delete(voorbeeld);
	}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		voorbeeldenRepository.deleteById(id);
	}
	
	public Iterable <Voorbeelden> findAll(){
		Iterable <Voorbeelden> result = voorbeeldenRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {	
		return voorbeeldenRepository.existsById(id);
	}
}