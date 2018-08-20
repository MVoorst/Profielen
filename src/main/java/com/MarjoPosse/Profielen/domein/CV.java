package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;
	private String noemVrijWilWerk;
	private String functie;
	private int nJarenGewerkt;
	private int hoeveelheid;
	
	@OneToOne
	Useraccount useraccount;
	
	public Useraccount getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getNoemVrijWilWerk() {
		return noemVrijWilWerk;
	}
	public void setNoemVrijWilWerk(String noemVrijWilWerk) {
		this.noemVrijWilWerk = noemVrijWilWerk;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	public int getnJarenGewerkt() {
		return nJarenGewerkt;
	}
	public void setnJarenGewerkt(int nJarenGewerkt) {
		this.nJarenGewerkt = nJarenGewerkt;
	}
	public int getHoeveelheid() {
		return hoeveelheid;
	}
	public void setHoeveelheid(int hoeveelheid) {
		this.hoeveelheid = hoeveelheid;
	}
}