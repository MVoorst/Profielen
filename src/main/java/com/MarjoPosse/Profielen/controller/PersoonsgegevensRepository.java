package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Persoonsgegevens;
@Component
public interface PersoonsgegevensRepository extends CrudRepository<Persoonsgegevens, Long>{

	}


