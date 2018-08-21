package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vraag extends Vragenlijst{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String contentvraag;

//	@ManyToOne
//	private Vragenlijst vragenlijst;
//	@OneToMany (fetch = FetchType.EAGER)
//	private List<Vragenlijst> vragenlijst;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
//	public Vragenlijst getVragenlijst() {
//		return vragenlijst;
//	}
//	public void setVragenlijst(Vragenlijst vragenlijst) {
//		this.vragenlijst = vragenlijst;
//	}
	
	public String getContentvraag() {
		return contentvraag;
	}
	public void setContentvraag(String contentvraag) {
		this.contentvraag = contentvraag;
	}
}