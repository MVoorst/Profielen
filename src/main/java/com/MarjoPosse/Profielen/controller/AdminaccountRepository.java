package com.MarjoPosse.Profielen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Adminaccount;


@Component
public interface AdminaccountRepository extends CrudRepository<Adminaccount, Long>{
	Optional<Adminaccount> findByGebruikersnaam(String gebruikersnaam);
	}


