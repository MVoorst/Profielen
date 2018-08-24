package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Vragenlijst {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id	
private long id;
private String vragenlijstnaam;

@OneToMany (fetch = FetchType.EAGER)
private List<Vraag> vragen;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getVragenlijstnaam() {
	return vragenlijstnaam;
}

public void setVragenlijstnaam(String vragenlijstnaam) {
	this.vragenlijstnaam = vragenlijstnaam;
}

public List<Vraag> getVragen() {
	return vragen;
}

public void setVragen(List<Vraag> vragen) {
	this.vragen = vragen;
}



}

