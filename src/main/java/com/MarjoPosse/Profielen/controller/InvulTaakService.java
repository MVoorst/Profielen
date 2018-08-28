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
	
	@Autowired
	private VraagRepository vraagRepository;
	
	@Autowired
	private UseraccountRepository useraccountRepository;
	

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
	
	public InvulTaak addToVraag (Vraag vraag, Useraccount user, String antwoord) {					//toegevoegd door Marjolijn
		InvulTaak invul = new InvulTaak();
		invul.setAntwoord(antwoord);
		invul.setVragenlijst(vraag);
		invul.setUseraccount(user);
		invultaakRepository.save(invul);
		return invul;
	}
	
	public Optional<Vraag> findByVraagId(Long id) {	//toegevoegd door M
		return vraagRepository.findById(id);
	}
	
	public boolean existsByVraagId(Long id) {	//toegevoegd door M
		return vraagRepository.existsById(id);
	}
	
	public Optional<Useraccount> findByUserId(Long id) {	//toegevoegd door M
		return useraccountRepository.findById(id);
	}
	
	public boolean existsByUserId(Long id) {	//toegevoegd door M
		return useraccountRepository.existsById(id);
	}
	
}