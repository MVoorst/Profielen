package com.MarjoPosse.Profielen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Useraccount;

@Component
public interface UseraccountRepository extends CrudRepository<Useraccount, Long>{

	Optional<Useraccount> findByGebruikersnaam(String gebruikersnaam);
	Optional<Useraccount> findByWachtwoord(String wachtwoord);
	Optional<Useraccount> findByEmailadres(String emailadres);
	//List<Useraccount> findByEmailAddressAndLastname(String emailAddress, String lastname);
	}

