package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class PersoonsgegevensService {
	
	@Autowired
	private PersoonsgegevensRepository persoonsgegevensRepository;

	public Persoonsgegevens save(Persoonsgegevens persoonsgegevens){
		return persoonsgegevensRepository.save(persoonsgegevens);
	}

	public Optional<Persoonsgegevens> findById(Long id) {
		return persoonsgegevensRepository.findById(id);
	}
	public void delete(Persoonsgegevens persoonsgegevens){
		persoonsgegevensRepository.delete(persoonsgegevens);
	}
	
	public Iterable <Persoonsgegevens> findAll(){
		Iterable <Persoonsgegevens> result = persoonsgegevensRepository.findAll();
		return result;
	}

	


}
