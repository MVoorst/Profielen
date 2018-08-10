package com.MarjoPosse.Profielen.api;

import java.util.Optional;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Path("useraccount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class UseraccountEndpoint {
	
	@Autowired
	private UseraccountRepository useraccountService;

	@GET
	public Response list(){
		return Response.ok(this.useraccountService.findAll()).build();
	}
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id")Long id) {
		Optional<Useraccount> optionaluseraccount=this.useraccountService.findById(id);
		if (optionaluseraccount.isPresent()){
			Useraccount useraccount = optionaluseraccount.get();
			 return Response.ok(useraccount).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}	

	@POST
	public Response create(Useraccount login) {		
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sbGeneratedPassword = new StringBuilder();
		Random random = new Random();
	    for (int i = 0; i < 6; i++) {
	        sbGeneratedPassword.append(characters.charAt(random.nextInt(characters.length())));
	     }
		login.setWachtwoord(sbGeneratedPassword.toString());  
		
		useraccountService.save (login);		
		return Response.accepted(login).build();

	}

	@POST				
	@Path("controle")		
	public Response checkLogin(Useraccount login) {
		if (login==null) {					
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		Optional<Useraccount> result = useraccountService.findByGebruikersnaam(login.getGebruikersnaam());	
		if (!result.isPresent()) {			
			return Response.status(Status.NOT_FOUND).build();
		} 
											
		Useraccount fLogin = result.get();		
		if (fLogin.getWachtwoord().equals(login.getWachtwoord())) {			
			return Response.accepted(fLogin.getId()).build();					
		}else {
			return Response.status(Status.NOT_ACCEPTABLE).build();		
		}	
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response Update(@PathParam("id") long id,Useraccount input) {
		
		Useraccount result = useraccountService.save(useraccount);
		return Response.accepted(result.getGebruikersnaam()).build();
	}
	
	@DELETE
	public Response deleteInlogpagina(Useraccount useraccount) {
		useraccountService.delete(useraccount);
		return Response.accepted(useraccount.getGebruikersnaam()).build();
	}
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <Useraccount> optionalToBeDeleted = this.useraccountService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.useraccountService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}