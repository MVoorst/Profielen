package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Inlogpagina;

@Component
public interface InlogpaginaRepository extends CrudRepository<Inlogpagina, Long>{
	}

