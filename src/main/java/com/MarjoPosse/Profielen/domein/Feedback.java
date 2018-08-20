package com.MarjoPosse.Profielen.domein;

import java.util.List;

import javax.persistence.*;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String inhoud;

	public List<Useraccount> getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(List<Useraccount> useraccount) {
		this.useraccount = useraccount;
	}

	@OneToMany (fetch = FetchType.EAGER)
	private List<Useraccount> useraccount;
	@ManyToOne
	Adminaccount adminaccount;

	
	
	public Adminaccount getAdminaccount() {
		return adminaccount;
	}

	public void setAdminaccount(Adminaccount adminaccount) {
		this.adminaccount = adminaccount;
	}

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
}