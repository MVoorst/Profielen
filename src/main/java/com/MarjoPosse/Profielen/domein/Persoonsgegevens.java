package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persoonsgegevens {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String voornaam;
	private String achternaam;
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
