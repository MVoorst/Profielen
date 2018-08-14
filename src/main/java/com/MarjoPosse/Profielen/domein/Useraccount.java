package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Useraccount {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String gebruikersnaam;
	private String wachtwoord;
	private String emailadres;
	
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private boolean geslacht;
	private int geboortedatum;
	private int huisnummer;
	private String straat;
	private String postcode;
	private String woonplaats;
	private String linkedinadres;
	private String githubadres;
	private String succes;
	
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public boolean isGeslacht() {
		return geslacht;
	}
	public void setGeslacht(boolean geslacht) {
		this.geslacht = geslacht;
	}
	public int getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(int geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	public String getLinkedinadres() {
		return linkedinadres;
	}
	public void setLinkedinadres(String linkedinadres) {
		this.linkedinadres = linkedinadres;
	}
	public String getGithubadres() {
		return githubadres;
	}
	public void setGithubadres(String githubadres) {
		this.githubadres = githubadres;
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
	public String getEmailadres() {
		return emailadres;
	}
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}
	public String getSucces() {
		return succes;
	}
	public void setSucces(String succes) {
		this.succes = succes;
	}
}