package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Vragenlijst {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
private long id;

private String vraag;
private int vragenhoeveelheid;

@ManyToOne
private Adminaccount persoon;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVraag1() {
		return vraag;
	}
	public void setVraag1(String vraag1) {
		this.vraag = vraag1;
	}
	public boolean isPresent() {
		return false;
	}
	public int getVragenhoeveelheid() {
		return vragenhoeveelheid;
	}
	public void setVragenhoeveelheid(int vragenhoeveelheid) {
		this.vragenhoeveelheid = vragenhoeveelheid;
	}
}

