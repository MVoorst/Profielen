package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class InvulTaak {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String antwoord;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAntwoord() {
		return antwoord;
	}

	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
}
