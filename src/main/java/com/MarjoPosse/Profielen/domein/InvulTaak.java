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
	
	@OneToOne
	private Useraccount useraccount;
	
	@ManyToOne
	private Vraag vragenlijst;
	
	@OneToOne
	private Feedback feedback;

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

	public Useraccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	public Vraag getVragenlijst() {
		return vragenlijst;
	}

	public void setVragenlijst(Vraag vragenlijst) {
		this.vragenlijst = vragenlijst;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
}
