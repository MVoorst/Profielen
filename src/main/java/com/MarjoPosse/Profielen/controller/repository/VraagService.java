package com.MarjoPosse.Profielen.controller.repository;

import java.util.Optional;

import com.MarjoPosse.Profielen.controller.interfaces.VraagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;

@Service
@Transactional
public class VraagService {

	@Autowired
	private VraagRepository vraagRepository;

	public Vraag save(Vraag vraag){
		return vraagRepository.save(vraag);
	}
	
	public Optional<Vraag> findById(Long id) {
		return vraagRepository.findById(id);
	}
	
	public void delete(Vraag vraag){
		vraagRepository.delete(vraag);
		}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		vraagRepository.deleteById(id);
	}
		
	public Iterable <Vraag> findAll(){
		Iterable<Vraag> result = vraagRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {
		return vraagRepository.existsById(id);
	}
}

