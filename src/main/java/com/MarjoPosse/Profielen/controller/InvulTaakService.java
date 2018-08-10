package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class InvulTaakService {
	
	@Autowired
	private InvulTaakRepository invultaakRepository;

	public InvulTaak save(InvulTaak invultaak){
		return invultaakRepository.save(invultaak);
	}

	public Optional<InvulTaak> findById(Long id) {
		return invultaakRepository.findById(id);
	}
	public void delete(InvulTaak invultaak){
		invultaakRepository.delete(invultaak);
	}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		invultaakRepository.deleteById(id);
	}
	
	public Iterable <InvulTaak> findAll(){
		Iterable <InvulTaak> result = invultaakRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {	
		return invultaakRepository.existsById(id);
	}
}