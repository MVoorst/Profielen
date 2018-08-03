package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class InlogpaginaService {
	
	@Autowired
	private InlogpaginaRepository inlogpaginaRepository;

	public Inlogpagina save(Inlogpagina inlogpagina){
		return inlogpaginaRepository.save(inlogpagina);
	}

	public Optional<Inlogpagina> findById(Long id) {
		return inlogpaginaRepository.findById(id);
	}
	public void delete(Inlogpagina inlogpagina){
		inlogpaginaRepository.delete(inlogpagina);
		}
	
	public Iterable <Inlogpagina> findAll(){
		Iterable <Inlogpagina> result = inlogpaginaRepository.findAll();
		return result;
	}
}
