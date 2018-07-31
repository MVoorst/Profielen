package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class VrijwilligerswerkService {
	
	@Autowired
	private VrijwilligerswerkRepository vrijwilligerswerkRepository;

	public Vrijwilligerswerk save(Vrijwilligerswerk vrijwilligerswerk){
		return vrijwilligerswerkRepository.save(vrijwilligerswerk);
	}

	public Optional<Vrijwilligerswerk> findById(Long id) {
		return vrijwilligerswerkRepository.findById(id);
	}
	
	public Iterable <Vrijwilligerswerk> findAll(){
		Iterable <Vrijwilligerswerk> result = vrijwilligerswerkRepository.findAll();
		return result;
	}
}