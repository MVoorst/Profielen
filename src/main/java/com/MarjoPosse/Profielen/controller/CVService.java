package com.MarjoPosse.Profielen.controller;

import java.io.File;
import java.util.Optional;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MarjoPosse.Profielen.domein.*;
@Service
@Transactional
public class CVService {
	
	@Autowired
	private CVRepository cvRepository;

	public CV save(CV cv){
		return cvRepository.save(cv);
	}
	
	public CV saveAsWord(CV cv) throws Docx4JException { //toegevoegd door Cris
	    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
	    MainDocumentPart mainDocument = wordMLPackage.getMainDocumentPart();
	    mainDocument.addStyledParagraphOfText("Title", "Qien CV");
	    mainDocument.addParagraphOfText(
	    		"Naam: ");
	    File exportFile = new File("QienCV.docx");	    
	    wordMLPackage.save(exportFile);
		return cvRepository.save(cv);	
	}

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