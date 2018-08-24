package com.MarjoPosse.Profielen.domein;



import javax.persistence.*;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String inhoud;
	

	@ManyToOne
	private Adminaccount adminaccount;

	@OneToOne
	private InvulTaak invulTaak;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInhoud() {
		return inhoud;
	}

	public void setInhoud(String inhoud) {
		this.inhoud = inhoud;
	}

	public Adminaccount getAdminaccount() {
		return adminaccount;
	}

	public void setAdminaccount(Adminaccount adminaccount) {
		this.adminaccount = adminaccount;
	}

	public InvulTaak getInvulTaak() {
		return invulTaak;
	}

	public void setInvulTaak(InvulTaak invulTaak) {
		this.invulTaak = invulTaak;
	}
	
	
}