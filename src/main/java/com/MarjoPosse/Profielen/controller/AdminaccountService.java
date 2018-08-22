package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.api.UseraccountEndpoint;
import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class AdminaccountService {
	
	@Autowired
	private AdminaccountRepository adminaccountRepository;

	public Adminaccount save(Adminaccount adminaccount){
		return adminaccountRepository.save(adminaccount);
	}

	public Optional<Adminaccount> findById(Long id) {
		return adminaccountRepository.findById(id);
	}
	
	public Optional <Adminaccount> findByGebruikersnaam (String gebruikersnaam) {
		return adminaccountRepository.findByGebruikersnaam(gebruikersnaam);
	}
	
	public void delete(Adminaccount adminaccount){
		adminaccountRepository.delete(adminaccount);
	}
	
	public Iterable <Adminaccount> findAll(){
		Iterable <Adminaccount> result = adminaccountRepository.findAll();
		return result;
	}

	public boolean existsById(Long id) {
		return false;
	}
	
	public boolean loginCheck(Adminaccount admin) {
		Optional<Adminaccount> result = adminaccountRepository.findByGebruikersnaam(admin.getGebruikersnaam());
		if (!result.isPresent()) {
			return false;
		}
		
		Adminaccount rightLogin = result.get();
		if (rightLogin.getWachtwoord().equals(admin.getWachtwoord())) {
			return true;
		}else {
			return false;
		}
	}

	public boolean maakUser() {
		UseraccountEndpoint useraccountEndpoint = new UseraccountEndpoint();
		useraccountEndpoint.create(null);
		//}
		return true;
	}
}
