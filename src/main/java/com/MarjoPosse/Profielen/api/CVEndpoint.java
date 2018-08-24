package com.MarjoPosse.Profielen.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import javax.ws.rs.PathParam;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.Message.Message;
import com.MarjoPosse.Profielen.controller.*;
import org.springframework.http.MediaType;

@Consumes(MediaType.APPLICATION_JSON_VALUE)
@Produces(MediaType.TEXT_PLAIN_VALUE)

@Path("cv")
@Component
public class CVEndpoint {
	
	@Autowired
	private CVService cvService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response listGroep(){
		Iterable <CV> cv = cvService.findAll();
		return Response.ok(cv).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response getCVById(@PathParam("id")Long id) {
		Optional<CV> optionalcv=this.cvService.findById(id);
		if (cvService.existsById(id)){
			Optional<CV> persoon = cvService.findById(id);
			 return Response.ok(persoon).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	public Response postVrijwilligerswerk(CV cv){
		CV result = cvService.save(cv);
		return Response.accepted(result.getNaam()).build();	
	}
	
	@POST //toegevoegd door Cris
	@Path("ExportAsWord")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public Response exportAsWord(CV cv) throws Docx4JException {
		cvService.saveAsWord(cv);
	    return Response.accepted(new Message("Succes")).build();
	}

	@POST
	@Path("docx")
	@Produces(MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public Response generateDocxFile(CV cv) throws Docx4JException {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");

		File exportFile = new File(cv.getUseraccount().getVoornaam()+".docx");
		wordPackage.save(exportFile);

		// Try to determine file's content type

		return Response.ok(exportFile).build();

//        Resource r = new FileSystemResource(exportFile);
//        String contentType = "application/octet-stream";
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + exportFile.getName() + "\"")
//                .body(exportFile);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	public Response putcv(CV cv) {
		CV result1 = cvService.save(cv);
		return Response.accepted(result1.getNaam()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	public Response deleteVrijwilligerswerk(CV cv) {
		cvService.delete(cv);
		return Response.accepted(cv.getNaam()).build();
	} 
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <CV> optionalToBeDeleted = this.cvService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.cvService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}