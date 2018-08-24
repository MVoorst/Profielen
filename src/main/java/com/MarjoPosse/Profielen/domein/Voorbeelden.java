package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voorbeelden {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Vraag vraag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vraag getVraag() {
		return vraag;
	}

	public void setVraag(Vraag vraag) {
		this.vraag = vraag;
	}
	
}
