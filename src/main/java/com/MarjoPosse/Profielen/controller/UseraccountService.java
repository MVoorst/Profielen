package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class UseraccountService {
	
	@Autowired
	private UseraccountRepository useraccountRepository;

	public Useraccount save(Useraccount useraccount){
		return useraccountRepository.save(useraccount);
	}

	public Optional<Useraccount> findById(Long id) {
		return useraccountRepository.findById(id);
	}
	
	public Optional<Useraccount> findByEmailadres(String emailadres) {
		return useraccountRepository.findByEmailadres(emailadres);
	}
	
	public void delete(Useraccount useraccount){
		useraccountRepository.delete(useraccount);
		}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		useraccountRepository.deleteById(id);
	}
	
	public Iterable <Useraccount> findAll(){
		Iterable <Useraccount> result = useraccountRepository.findAll();
		return result;
	}
	public Optional <Useraccount> findByGebruiksernaam (String gebruikersnaam) {
		return useraccountRepository.findByGebruikersnaam(gebruikersnaam);
	}
	
	public boolean existsById(Long id) {
		return false;

	}
	
	public boolean loginCheck(Useraccount user) {
		Optional<Useraccount> result = useraccountRepository.findByEmailadres(user.getEmailadres());
		if (!result.isPresent()) {
			return false;
		}
		
		Useraccount rightLogin = result.get();
		if (rightLogin.getWachtwoord().equals(user.getWachtwoord())) {
			return true;
		}else {
			return false;
		}

	}
}

