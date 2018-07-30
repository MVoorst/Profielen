package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vrijwilligerswerk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private boolean prik;
	private String verpakking;
	private int prijs;
	private int hoeveelheid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isPrik() {
		return prik;
	}
	public void setPrik(boolean prik) {
		this.prik = prik;
	}
	public String getVerpakking() {
		return verpakking;
	}
	public void setVerpakking(String verpakking) {
		this.verpakking = verpakking;
	}
	public int getPrijs() {
		return prijs;
	}
	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}
	public int getHoeveelheid() {
		return hoeveelheid;
	}
	public void setHoeveelheid(int hoeveelheid) {
		this.hoeveelheid = hoeveelheid;
	}
}