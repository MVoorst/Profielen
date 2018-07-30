package com.MarjoPosse.Profielen.domein;

<<<<<<< HEAD
public class Opleidingen {
// hier komen de opleidingen
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opleidingen {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	
	long id;

public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpleiding() {
		return opleiding;
	}

	public void setOpleiding(String opleiding) {
		this.opleiding = opleiding;
	}

	// hier komen de opleidingen
>>>>>>> master
	String opleiding = "";
}
