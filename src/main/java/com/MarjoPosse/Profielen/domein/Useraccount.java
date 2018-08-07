package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Useraccount {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
private long id;
private String gebruikersnaam;
private String wachtwoord;



public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getGebruikersnaam() {
	return gebruikersnaam;
}
public void setGebruikersnaam(String gebruikersnaam) {
	this.gebruikersnaam = gebruikersnaam;
}
public String getWachtwoord() {
	return wachtwoord;
}
public void setWachtwoord(String wachtwoord) {
	this.wachtwoord = wachtwoord;
}
}