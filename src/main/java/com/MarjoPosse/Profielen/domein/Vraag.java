package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;
import java.util.List;

@Entity

public class Vraag{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String contentvraag;

	@OneToOne
	Vragenlijst vragenlijst;
//	@ManyToOne
//	private Vragenlijst vragenlijst;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContentvraag() {
		return contentvraag;
	}

	public void setContentvraag(String contentvraag) {
		this.contentvraag = contentvraag;
	}

//<<<<<<< HEAD
//	public Vragenlijst getVragenlijst() {
//		return vragenlijst;
//	}
//
//	public void setVragenlijst(Vragenlijst vragenlijst) {
//		this.vragenlijst = vragenlijst;
//	}
//=======
//	public Vragenlijst getVragenlijst() {
//		return vragenlijst;
//	}
//
//	public void setVragenlijst(Vragenlijst vragenlijst) {
//		this.vragenlijst = vragenlijst;
//	}
//	

}