package com.MarjoPosse.Profielen.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Vragenlijst;

@Component
public interface VragenlijstRepository extends CrudRepository<Vragenlijst, Long>{
	
}
