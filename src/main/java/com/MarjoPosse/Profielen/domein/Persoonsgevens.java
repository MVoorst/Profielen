package com.MarjoPosse.Profielen.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persoonsgevens {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	

}
