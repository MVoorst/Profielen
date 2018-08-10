package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;

@Entity
public class Vragen {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id	
private long id;
private String[] vraag1;
private String vraag2;
private String vraag3;
private String vraag4;

@ManyToOne
private Adminaccount persoon;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String[] getVraag1() {
		return vraag1;
	}
	public void setVraag1(String[] vraag1) {
		this.vraag1 = vraag1;
	}
	public String getVraag2() {
		return vraag2;
	}
	public void setVraag2(String vraag2) {
		this.vraag2 = vraag2;
	}
	public String getVraag3() {
		return vraag3;
	}
	public void setVraag3(String vraag3) {
		this.vraag3 = vraag3;
	}
	public String getVraag4() {
		return vraag4;
	}
	public void setVraag4(String vraag4) {
		this.vraag4 = vraag4;
	}
	public boolean isPresent() {
		return false;
	}
}

