package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Werkervaring {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
long id;
String naam;

long getId() {
	return id;
}
void setId(long id) {
	this.id = id;
}
String getNaam() {
	return naam;
}
void setId(String naam) {
	this.naam = naam;
}
}

