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
