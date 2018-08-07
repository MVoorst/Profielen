package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Useraccount;

@Component
public interface UseraccountRepository extends CrudRepository<Useraccount, Long>{
	}

