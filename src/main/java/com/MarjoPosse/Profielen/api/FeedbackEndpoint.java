package com.MarjoPosse.Profielen.api;

import java.util.Optional;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.MarjoPosse.Profielen.controller.repository.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;

@Path("feedback")
@Component
public class FeedbackEndpoint {
	
	@Autowired
	private FeedbackService feedbackService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Feedback> feedback = feedbackService.findAll();
		return Response.ok(feedback).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFeedbackById(@PathParam("id")Long id) {
		Optional<Feedback> optionalfeedback=this.feedbackService.findById(id);
		if (feedbackService.existsById(id)){
			Optional<Feedback> persoon = feedbackService.findById(id);
			 return Response.ok(persoon).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postInlogpagina(Feedback feedback){
		Feedback result = feedbackService.save(feedback);
		return Response.accepted(result.getId()).build();	
	}
	
	/*@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postInloggegevens(@PathParam("id") Long id,Inlogpagina useraccount) {
		if(){
		Inlogpagina result = inlogpaginaService.save(useraccount);
		return  Response.accepted(result.getId()).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response Update(@PathParam("id") long id,Useraccount input) {
	putInlogpagina(Useraccount useraccount) {
		Optional<Useraccount> optionaluseraccountUpdate=this.useraccountService.findById(id);
		if(optionaluseraccountUpdate isPresent) {
		
		Useraccount result = useraccountService.save(useraccount);
		return Response.accepted(result.getGebruikersnaam()).build();
	}*/
	
	@DELETE
	@Consumes (MediaType.APPLICATION_JSON)
	public Response deleteInlogpagina(Feedback feedback) {
		feedbackService.delete(feedback);
		return Response.accepted(feedback.getId()).build();
	}
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <Feedback> optionalToBeDeleted = this.feedbackService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.feedbackService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
