package com.MarjoPosse.Profielen.domein;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Adminaccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String voornaam;
	private String achternaam;
	private String gebruikersnaam;
	private String wachtwoord;
	private String straat;
	private int huisnummer;
	private String woonplaats;
	private int leeftijd;
	private String geslacht;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getvoornaam() {
		return voornaam;
	}
	public void setvoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getachternaam() {
		return achternaam;
	}
	public void setachternaam(String achternaam) {
		this.achternaam = achternaam;
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
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	public String getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	public String getGeslacht() {
		return geslacht;
	}
	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

}
