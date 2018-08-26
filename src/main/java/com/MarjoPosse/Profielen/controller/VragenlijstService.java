package com.MarjoPosse.Profielen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;

@Service
@Transactional
public class VragenlijstService {
	
	@Autowired
	private VragenlijstRepository vragenlijstRepository;

	public Vragenlijst save(Vragenlijst vragenlijst){
		return vragenlijstRepository.save(vragenlijst);
	}
	
	public Optional<Vragenlijst> findById(Long id) {
		return vragenlijstRepository.findById(id);
	}

	
	public void delete(Vragenlijst vragen){
		vragenlijstRepository.delete(vragen);
		}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		vragenlijstRepository.deleteById(id);
	}
		
	public Iterable <Vragenlijst> findAll(){
		Iterable <Vragenlijst> result = vragenlijstRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {
		
		return vragenlijstRepository.existsById(id);
	}
	
	public void huppakee () { // hoppakee door marjoleijnnn
		vragenlijstRepository.save(new Vragenlijst());
		System.out.println("hoppa");
	}

	public void huppakee2 () { // hoppakee door marjoleijnnn
		vragenlijstRepository.save(new Vragenlijst());
		System.out.println("hoppa");
	}
	
}
