package com.MarjoPosse.Profielen.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.MarjoPosse.Profielen.domein.InvulTaak;

@Component
public interface InvulTaakRepository extends CrudRepository<InvulTaak, Long>{
	}
