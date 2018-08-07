package com.MarjoPosse.Profielen.controller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Vragen;

@Component
public interface VragenRepository extends CrudRepository<Vragen, Long>{
	}
