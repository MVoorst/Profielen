package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Vrijwilligerswerk;

@Component
public interface VrijwilligerswerkRepository extends CrudRepository<Vrijwilligerswerk, Long>{
	}

