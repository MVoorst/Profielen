package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Werkervaring {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
private long id;
private String naam;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getVoornaam() {
	return naam;
}
public void setVoornaam(String naam) {
	this.naam = naam;
}
}

