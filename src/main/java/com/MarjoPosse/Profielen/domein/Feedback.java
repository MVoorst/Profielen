package com.MarjoPosse.Profielen.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String inhoud;
	
//	@OneToMany
//	Useraccount useraccount;
	
	@ManyToOne
	Adminaccount adminaccount;
	
//    private List feedback;
//
//    public void addPhone(Feedback fb) {
//        this.feedback.add(fb);
////        if (fb.getInhoud() != this) {
////            fb.setOwner(this);
////        }
//    }
	
	
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