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
	public void delete(Useraccount useraccount){
		useraccountRepository.delete(useraccount);
		}
	
	public Iterable <Useraccount> findAll(){
		Iterable <Useraccount> result = useraccountRepository.findAll();
		return result;
	}

	public boolean existsById(Long id) {
		return false;
	}

	
}
