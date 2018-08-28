package com.MarjoPosse.Profielen.controller;

import java.io.*;
import java.util.Optional;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.Color;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.RPr;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class CVService {
	
	@Autowired
	private CVRepository cvRepository;

	public CV save(CV cv){
		return cvRepository.save(cv);
	}

//    public CV saveAsWord(CV cv) throws Docx4JException { //toegevoegd door Arne
//	    WordGenerator.createIt(cv);
//	    System.out.println("Word document aangemaakt");
//		return cvRepository.save(cv);
//	}


	public CV saveAsWord(CV cv) throws Docx4JException { //toegevoegd door Cris - aangepast door Arne
		// Eerst de fields aanmaken voor in het CV
		String voornaam, tussenvoegsel, leeftijd, achternaam, woonplaats, githubadres, vraag, antwoord, motivatie, iqtest, project, opleiding, diploma, opleidingVan, opleidingTot, school, functie1, functie2, functie3, werkervaring1, werkervaring2, werkervaring3, bedrijf1, bedrijf2, bedrijf3, werkervaringVan1, werkervaringVan2, werkervaringVan3, werkervaringTot1, werkervaringTot2, werkervaringTot3, werkervaringSubtitel1, werkervaringSubtitel2, werkervaringSubtitel3;
		int geboortedatum;


//		String name; // alleen met template - Omweg

		// ======= begin === USERACCOUNT ========
		// ======= begin === samengestelde stuk ========
		voornaam = cv.getUseraccount().getVoornaam();
		tussenvoegsel = cv.getUseraccount().getTussenvoegsel();
		achternaam = cv.getUseraccount().getAchternaam();
		// ======= einde === samengestelde stuk ========

		geboortedatum = cv.getUseraccount().getGeboortedatum();
		woonplaats = cv.getUseraccount().getWoonplaats();
		githubadres = cv.getUseraccount().getGithubadres();
//		leeftijd = cv.getUseraccount().getLeeftijd(); // is een String ipv een INT
//		iqtest = cv.getUseraccount().getIqtest();
//		project = cv.getUseraccount().getProject();


/*
		// ======= begin === samengestelde stuk ========
		opleiding = cv.getUseraccount().getOpleiding();
		diploma = cv.getUseraccount().getDiploma();
		school = cv.getUseraccount().getSchool();
		opleidingVan = cv.getUseraccount().getOpleidingVan();
		opleidingTot = cv.getUseraccount().getOpleidingTot();
		// ======= einde === samengestelde stuk ========

		// ======= begin === samengestelde stuk === 3 voorbeelden van 3 bedrijven. Dit kan makkelijker maar nu ff werkend krijgen ========
		bedrijf1 = cv.getUseraccount().getBedrijf1();
		functie1 = cv.getUseraccount().getFunctie1();
		werkervaring1 = cv.getUseraccount().getWerkervaring1();
		werkervaringVan1 = cv.getUseraccount().getWerkervaringVan1();
		werkervaringTot1 = cv.getUseraccount().getWerkervaringTot1();
		werkervaringSubtitel1 = cv.getUseraccount().getWerkervaringSubtitel1();
		// ======= einde === samengestelde stuk ========

		// ======= begin === samengestelde stuk === 3 voorbeelden van 3 bedrijven. Dit kan makkelijker maar nu ff werkend krijgen ========
		bedrijf2 = cv.getUseraccount().getBedrijf2();
		functie2 = cv.getUseraccount().getFunctie2();
		werkervaring2 = cv.getUseraccount().getWerkervaring2();
		werkervaringVan2 = cv.getUseraccount().getWerkervaringVan2();
		werkervaringTot2 = cv.getUseraccount().getWerkervaringTot2();
		werkervaringSubtitel2 = cv.getUseraccount().getWerkervaringSubtitel2();
		// ======= einde === samengestelde stuk ========

		// ======= begin === samengestelde stuk === 3 voorbeelden van 3 bedrijven. Dit kan makkelijker maar nu ff werkend krijgen ========
		bedrijf3 = cv.getUseraccount().getBedrijf3();
		functie3 = cv.getUseraccount().getFunctie3();
		werkervaring3 = cv.getUseraccount().getWerkervaring3();
		werkervaringVan3 = cv.getUseraccount().getWerkervaringVan3();
		werkervaringTot3 = cv.getUseraccount().getWerkervaringTot3();
		werkervaringSubtitel3 = cv.getUseraccount().getWerkervaringSubtitel3();
		// ======= einde === samengestelde stuk ========
		*/

		// ======= begin === INVULTAAK !!! Werkt nog niet vanwege sets uit de database ========
//		vraag = String.valueOf(cv.getUseraccount().getInvultaak());
//		antwoord = String.valueOf(cv.getUseraccount().getInvultaak());
//		motivatie = cv.getUseraccount().getInvultaak();
		// ======= einde === INVULTAAKn ========


		// Einde van de fields.

	    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage(); // word package aanmaken
//		WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(name))); // alleen met template, werkt met placeholders maar is risky!
	    MainDocumentPart mainDocument = wordMLPackage.getMainDocumentPart(); // body voor word klaarzetten
		File image = new File("logoQienTrans.png");
		byte[] fileContent = new byte[0];
		try {
			fileContent = Files.readAllBytes(image.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		BinaryPartAbstractImage imagePart = null;
		try {
			imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage , fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Inline inline = null;
		try {
			inline = imagePart.createImageInline("Logo QIen", "Alt Text", 1, 2, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		P Imageparagraph = addImageToParagraph(inline);
		mainDocument.getContent().add(Imageparagraph);
	    mainDocument.addStyledParagraphOfText("Title", "Qien CV"); // body vullen

		// vanaf hier is het de inhoud van het document
		// ======= begin === tekst met andere kleur ========
		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = factory.createP();
		R r = factory.createR();
		Text t = factory.createText();
		t.setValue("Persoonlijke gegevens");
		r.getContent().add(t);
		p.getContent().add(r);
		RPr rpr = factory.createRPr();
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		rpr.setB(b);
		rpr.setI(b);
		rpr.setCaps(b);
		Color purple = factory.createColor();
		purple.setVal("purple");
		rpr.setColor(purple);
		r.setRPr(rpr);
		mainDocument.getContent().add(p);
		// ======= einde === tekst met andere kleur ========
if(tussenvoegsel != null) {
	mainDocument.addParagraphOfText("Naam: " + voornaam + " " +  tussenvoegsel +" " + achternaam);
} else {
	mainDocument.addParagraphOfText("Naam: " + voornaam +" " + achternaam);
}
		mainDocument.addParagraphOfText("Geboortedatum: " + geboortedatum);
		mainDocument.addParagraphOfText("Woonplaats: " + woonplaats);
		mainDocument.addParagraphOfText("Github Adres: " + githubadres);
//		mainDocument.addParagraphOfText("IQ score: " + iqtest);
		// ======= begin === samengestelde stuk ========
		// ======= begin === tekst met andere kleur ========
		ObjectFactory factory1 = Context.getWmlObjectFactory();
		P p1 = factory1.createP();
		R r1 = factory1.createR();
		Text t1 = factory1.createText();
		t1.setValue("Vaardigheden");
		r1.getContent().add(t1);
		p1.getContent().add(r1);
		RPr rpr1 = factory1.createRPr();
		BooleanDefaultTrue b1 = new BooleanDefaultTrue();
		rpr1.setB(b1);
		rpr1.setI(b1);
		rpr1.setCaps(b1);
		Color purple1 = factory1.createColor();
		purple1.setVal("purple");
		rpr1.setColor(purple1);
		r1.setRPr(rpr1);
		mainDocument.getContent().add(p1);
		// ======= begin === tekst met andere kleur ========
		mainDocument.addParagraphOfText("java 8\n Hibernate\n Maven\n Spring\n HTML5\n CSS3\n" +
				"Bootstrap\n JavaScript\n JQuery\n" +
				"Backbone\n JS\n SQL\n" +
				"SCRUM\n");
		// ======= einde === samengestelde stuk ========
		// ======= begin === tekst met andere kleur ========
		ObjectFactory factory2 = Context.getWmlObjectFactory();
		P p2 = factory2.createP();
		R r2 = factory2.createR();
		Text t2 = factory2.createText();
		t2.setValue("Vragen");
		r2.getContent().add(t2);
		p2.getContent().add(r2);
		RPr rpr2 = factory2.createRPr();
		BooleanDefaultTrue b2 = new BooleanDefaultTrue();
		rpr2.setB(b2);
		rpr2.setI(b2);
		rpr2.setCaps(b2);
		Color purple2 = factory2.createColor();
		purple2.setVal("purple");
		rpr2.setColor(purple2);
		r2.setRPr(rpr2);
		mainDocument.getContent().add(p2);
		// ======= einde === tekst met andere kleur ========
		// ======= begin === tekst met andere kleur ========
		ObjectFactory factory3 = Context.getWmlObjectFactory();
		P p3 = factory3.createP();
		R r3 = factory3.createR();
		Text t3 = factory3.createText();
		t3.setValue("Wat is jou motivatie om bij Qien te beginnen?");
		r3.getContent().add(t3);
		p3.getContent().add(r3);
		RPr rpr3 = factory3.createRPr();
		BooleanDefaultTrue b3 = new BooleanDefaultTrue();
		rpr3.setB(b3);
		rpr3.setI(b3);
		rpr3.setCaps(b3);
		Color red = factory3.createColor();
		red.setVal("red");
		rpr3.setColor(red);
		r3.setRPr(rpr3);
		mainDocument.getContent().add(p3);
		// ======= einde === tekst met andere kleur ========
		mainDocument.addParagraphOfText("Dit ben ik: in mijn tienerjaren begonnen met het coderen van games en toen is mijn liefde ontstaan voor programmeren.\n" +
				"Door mijn analytisch vermogen, nieuwsgierig- en leergierigheid, pak ik de zaken snel op en krijg ik veel energie van het opleveren van werkbare code en software oplossingen. Dit doe ik graag met een leuk team waarin je elkaar helpt en versterkt.\n");

//		mainDocument.addParagraphOfText("Project: " + project);
//		mainDocument.addParagraphOfText("Leeftijd: " + leeftijd);
//		mainDocument.addParagraphOfText("Opleiding: " + opleiding);
//		mainDocument.addParagraphOfText("Diploma: " + diploma);
//		mainDocument.addParagraphOfText("van: " + opleidingVan + " - tot " +opleidingTot);
//		mainDocument.addParagraphOfText("School: " + school);
//		mainDocument.addParagraphOfText("School: " + school);

		/*
		Vraag en antwoord komen hier
		 */

	    File exportFile = new File(cv.getUseraccount().getVoornaam()+cv.getUseraccount().getAchternaam()+".docx");
		wordMLPackage.save(exportFile);
		return cvRepository.save(cv);
	}

	private static P addImageToParagraph(Inline inline) {
		ObjectFactory factory = new ObjectFactory();
		P p = factory.createP();
		R r = factory.createR();
		p.getContent().add(r);
		Drawing drawing = factory.createDrawing();
		r.getContent().add(drawing);
		drawing.getAnchorOrInline().add(inline);
		return p;
	}

	/*
	// Dit stukje is door Arne gedaan om een template te laden en met placeholders te werken.
			public CV saveAsWord(CV cv) throws Docx4JException {
			private WordprocessingMLPackage getTemplate(String name) throws Docx4JException, FileNotFoundException {
		WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(name)));
		return template;
	}


	 */

	public Optional<CV> findById(Long id) {
		return cvRepository.findById(id);
	}
	public void delete(CV cv){
		cvRepository.delete(cv);
	}
	
	public void deleteById(Long id) { //toegevoegd door Cris
		cvRepository.deleteById(id);
	}
	
	
	public Iterable <CV> findAll(){
		Iterable <CV> result = cvRepository.findAll();
		return result;
	}
	
	public boolean existsById(Long id) {
		
		return cvRepository.existsById(id);
	}


}