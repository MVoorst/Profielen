package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class AdminaccountService {
	
	@Autowired
	private AdminaccountRepository adminaccountRepository;

	public Adminaccount save(Adminaccount persoon){
		return adminaccountRepository.save(persoon);
	}

	public Optional<Adminaccount> findById(Long id) {
		return adminaccountRepository.findById(id);
	}
	public void delete(Adminaccount persoon){
		adminaccountRepository.delete(persoon);
	}
	
	public Iterable <Adminaccount> findAll(){
		Iterable <Adminaccount> result = adminaccountRepository.findAll();
		return result;
	}

	public boolean existsById(Long id) {
		return false;
	}

	


}
