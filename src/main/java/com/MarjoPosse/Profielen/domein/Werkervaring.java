package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Werkervaring {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
private long id;
private String naam;
private String noemWerkgever;
private String functie;
private int nJarenErvaring;


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
public String getNoemWerkgever() {
	return noemWerkgever;
}
public void setNoemWerkgever(String noemWerkgever) {
	this.noemWerkgever = noemWerkgever;
}
public String getFunctie() {
	return functie;
}
public void setFunctie(String functie) {
	this.functie = functie;
}
public int getnJarenErvaring() {
	return nJarenErvaring;
}
public void setnJarenErvaring(int nJarenErvaring) {
	this.nJarenErvaring = nJarenErvaring;
}
}

