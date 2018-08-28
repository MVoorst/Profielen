package com.MarjoPosse.Profielen.domein;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Useraccount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

		private String gebruikersnaam;
		private String wachtwoord;
		private String emailadres;
		private String voornaam;
		private String tussenvoegsel;
		private String achternaam;
		private boolean geslacht;
		private int geboortedatum;
		private int huisnummer;
		private String straat;
		private String postcode;
		private String woonplaats;
		private String linkedinadres;
		private String githubadres;
		/*
	private String leeftijd;
		private String opleiding;
		private String diploma;
		private String opleidingVan;
			private String opleidingTot;
			private String school;
			private String functie1;
			private String functie2;
			private String functie3;
	private String werkervaring1;
			private String werkervaring2;
			private String werkervaring3;
			private String bedrijf1;
			private String bedrijf2;
			private String bedrijf3;
			private String werkervaringVan1;
			private String werkervaringVan2;
			private String werkervaringVan3;
			private String werkervaringTot1;
			private String werkervaringTot2;
			private String werkervaringTot3;
			private String werkervaringSubtitel1;
			private String werkervaringSubtitel2;
			private String werkervaringSubtitel3;
			*/
			private String iqtest;
		private String project;


@OneToMany(fetch = FetchType.EAGER)
private Set<InvulTaak> invultaak;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getGebruikersnaam() {
	return gebruikersnaam;
}

public void setGebruikersnaam(String gebruikersnaam) {
	this.gebruikersnaam = gebruikersnaam;
}

public String getWachtwoord() {
	return wachtwoord;
}

public void setWachtwoord(String wachtwoord) {
	this.wachtwoord = wachtwoord;
}

public String getEmailadres() {
	return emailadres;
}

public void setEmailadres(String emailadres) {
	this.emailadres = emailadres;
}

public String getVoornaam() {
	return voornaam;
}

public void setVoornaam(String voornaam) {
	this.voornaam = voornaam;
}

public String getTussenvoegsel() {
	return tussenvoegsel;
}

public void setTussenvoegsel(String tussenvoegsel) {
	this.tussenvoegsel = tussenvoegsel;
}

public String getAchternaam() {
	return achternaam;
}

public void setAchternaam(String achternaam) {
	this.achternaam = achternaam;
}

public boolean isGeslacht() {
	return geslacht;
}

public void setGeslacht(boolean geslacht) {
	this.geslacht = geslacht;
}

public int getGeboortedatum() {
	return geboortedatum;
}

public void setGeboortedatum(int geboortedatum) {
	this.geboortedatum = geboortedatum;
}

public int getHuisnummer() {
	return huisnummer;
}

public void setHuisnummer(int huisnummer) {
	this.huisnummer = huisnummer;
}

public String getStraat() {
	return straat;
}

public void setStraat(String straat) {
	this.straat = straat;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public String getWoonplaats() {
	return woonplaats;
}

public void setWoonplaats(String woonplaats) {
	this.woonplaats = woonplaats;
}

public String getLinkedinadres() {
	return linkedinadres;
}

public void setLinkedinadres(String linkedinadres) {
	this.linkedinadres = linkedinadres;
}

public String getGithubadres() {
	return githubadres;
}

public void setGithubadres(String githubadres) {
	this.githubadres = githubadres;
}

public Set<InvulTaak> getInvultaak() {
	return invultaak;
}

public void setInvultaak(Set<InvulTaak> invultaak) {
	this.invultaak = invultaak;
}

	public String getIqtest() {
		return iqtest;
	}

	public void setIqtest(String iqtest) {
		this.iqtest = iqtest;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
//
//
//	public String getOpleiding() {
//		return opleiding;
//	}
//
//	public void setOpleiding(String opleiding) {
//		this.opleiding = opleiding;
//	}
//
//	public String getDiploma() {
//		return diploma;
//	}
//
//	public void setDiploma(String diploma) {
//		this.diploma = diploma;
//	}
//
//	public String getOpleidingVan() {
//		return opleidingVan;
//	}
//
//	public void setOpleidingVan(String opleidingVan) {
//		this.opleidingVan = opleidingVan;
//	}
//
//	public String getOpleidingTot() {
//		return opleidingTot;
//	}
//
//	public void setOpleidingTot(String opleidingTot) {
//		this.opleidingTot = opleidingTot;
//	}
//
//	public String getSchool() {
//		return school;
//	}
//
//	public void setSchool(String school) {
//		this.school = school;
//	}
//
//	public String getFunctie1() {
//		return functie1;
//	}
//
//	public void setFunctie1(String functie1) {
//		this.functie1 = functie1;
//	}
//
//	public String getFunctie2() {
//		return functie2;
//	}
//
//	public void setFunctie2(String functie2) {
//		this.functie2 = functie2;
//	}
//
//	public String getFunctie3() {
//		return functie3;
//	}
//
//	public void setFunctie3(String functie3) {
//		this.functie3 = functie3;
//	}
//
//	public String getWerkervaring1() {
//		return werkervaring1;
//	}
//
//	public void setWerkervaring1(String werkervaring1) {
//		this.werkervaring1 = werkervaring1;
//	}
//
//	public String getWerkervaring2() {
//		return werkervaring2;
//	}
//
//	public void setWerkervaring2(String werkervaring2) {
//		this.werkervaring2 = werkervaring2;
//	}
//
//	public String getWerkervaring3() {
//		return werkervaring3;
//	}
//
//	public void setWerkervaring3(String werkervaring3) {
//		this.werkervaring3 = werkervaring3;
//	}
//
//	public String getBedrijf1() {
//		return bedrijf1;
//	}
//
//	public void setBedrijf1(String bedrijf1) {
//		this.bedrijf1 = bedrijf1;
//	}
//
//	public String getBedrijf2() {
//		return bedrijf2;
//	}
//
//	public void setBedrijf2(String bedrijf2) {
//		this.bedrijf2 = bedrijf2;
//	}
//
//	public String getBedrijf3() {
//		return bedrijf3;
//	}
//
//	public void setBedrijf3(String bedrijf3) {
//		this.bedrijf3 = bedrijf3;
//	}
//
//	public String getWerkervaringVan1() {
//		return werkervaringVan1;
//	}
//
//	public void setWerkervaringVan1(String werkervaringVan1) {
//		this.werkervaringVan1 = werkervaringVan1;
//	}
//
//	public String getWerkervaringVan2() {
//		return werkervaringVan2;
//	}
//
//	public void setWerkervaringVan2(String werkervaringVan2) {
//		this.werkervaringVan2 = werkervaringVan2;
//	}
//
//	public String getWerkervaringVan3() {
//		return werkervaringVan3;
//	}
//
//	public void setWerkervaringVan3(String werkervaringVan3) {
//		this.werkervaringVan3 = werkervaringVan3;
//	}
//
//	public String getWerkervaringTot1() {
//		return werkervaringTot1;
//	}
//
//	public void setWerkervaringTot1(String werkervaringTot1) {
//		this.werkervaringTot1 = werkervaringTot1;
//	}
//
//	public String getWerkervaringTot2() {
//		return werkervaringTot2;
//	}
//
//	public void setWerkervaringTot2(String werkervaringTot2) {
//		this.werkervaringTot2 = werkervaringTot2;
//	}
//
//	public String getWerkervaringTot3() {
//		return werkervaringTot3;
//	}
//
//	public void setWerkervaringTot3(String werkervaringTot3) {
//		this.werkervaringTot3 = werkervaringTot3;
//	}
//
//	public String getWerkervaringSubtitel1() {
//		return werkervaringSubtitel1;
//	}
//
//	public void setWerkervaringSubtitel1(String werkervaringSubtitel1) {
//		this.werkervaringSubtitel1 = werkervaringSubtitel1;
//	}
//
//	public String getWerkervaringSubtitel2() {
//		return werkervaringSubtitel2;
//	}
//
//	public void setWerkervaringSubtitel2(String werkervaringSubtitel2) {
//		this.werkervaringSubtitel2 = werkervaringSubtitel2;
//	}
//
//	public String getWerkervaringSubtitel3() {
//		return werkervaringSubtitel3;
//	}
//
//	public void setWerkervaringSubtitel3(String werkervaringSubtitel3) {
//		this.werkervaringSubtitel3 = werkervaringSubtitel3;
//	}
//
//	public String getLeeftijd() {
//		return leeftijd;
//	}
//
//	public void setLeeftijd(String leeftijd) {
//		this.leeftijd = leeftijd;
//	}

}