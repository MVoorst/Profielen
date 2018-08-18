package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Vraag {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String contentvraag;

	@ManyToOne
	private Vragenlijst vragenlijst;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Vragenlijst getVragenlijst() {
		return vragenlijst;
	}
	public void setVragenlijst(Vragenlijst vragenlijst) {
		this.vragenlijst = vragenlijst;
	}
	
	public String getContentvraag() {
		return contentvraag;
	}
	public void setContentvraag(String contentvraag) {
		this.contentvraag = contentvraag;
	}
}