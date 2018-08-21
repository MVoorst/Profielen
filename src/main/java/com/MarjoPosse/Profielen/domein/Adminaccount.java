package com.MarjoPosse.Profielen.domein;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Adminaccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String naamMaster;
	private String gebruikersnaam;
	private String wachtwoord;
//	private Set<Feedback> feedbackFunctie = new HashSet<Feedback>(0);

	// One to many relaties
	@OneToOne
	Vragenlijst vragenlijst;
//	@OneToMany(fetch = FetchType.LAZY)
//	public List<Feedback> feedback;
//	@OneToMany
//	public Set<Voorbeelden> voorbeeld;

	
//	public void feedbackFunctie(Set<Feedback> feedbackFunctie) {
//		this.feedbackFunctie = feedbackFunctie;
//	}
	
	public Vragenlijst getVragenlijst() {
		return vragenlijst;
	}
	public void setVragenlijst(Vragenlijst vragenlijst) {
		this.vragenlijst = vragenlijst;
	}
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
	public String getNaamMaster() {
		return naamMaster;
	}
	public void setNaamMaster(String naamMaster) {
		this.naamMaster = naamMaster;
	}
}
