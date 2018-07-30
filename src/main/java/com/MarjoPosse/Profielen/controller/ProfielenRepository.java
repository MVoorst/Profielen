package com.MarjoPosse.Profielen.controller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Werkervaring;

@Component
public interface ProfielenRepository extends CrudRepository<Werkervaring, Long>{
	}
