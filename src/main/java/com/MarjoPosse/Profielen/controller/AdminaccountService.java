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

	public Adminaccount save(Adminaccount adminaccount){
		return adminaccountRepository.save(adminaccount);
	}

	public Optional<Adminaccount> findById(Long id) {
		return adminaccountRepository.findById(id);
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
	
	public void logincheck(Adminaccount admin) {
		Optional<Adminaccount> result = findByUserName(admin.getUserName());
		
	}

	


}
