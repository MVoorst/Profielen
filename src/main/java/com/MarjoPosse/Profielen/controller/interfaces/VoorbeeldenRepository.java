package com.MarjoPosse.Profielen.controller.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.Voorbeelden;

@Component 
public interface VoorbeeldenRepository extends CrudRepository<Voorbeelden, Long>{

}
