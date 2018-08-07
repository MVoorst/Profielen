package com.MarjoPosse.Profielen.api;

import java.util.Optional;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Path("useraccount")
@Component
public class UseraccountEndpoint {
	
	@Autowired
	private UseraccountService useraccountService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Useraccount> useraccount = useraccountService.findAll();
		return Response.ok(useraccount).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUseraccountById(@PathParam("id")Long id) {
		Optional<Useraccount> optionaluseraccount=this.useraccountService.findById(id);
		if (useraccountService.existsById(id)){
			Optional<Useraccount> persoon = useraccountService.findById(id);
			 return Response.ok(persoon).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postInlogpagina(Useraccount useraccount){
		Useraccount result = useraccountService.save(useraccount);
		return Response.accepted(result.getGebruikersnaam()).build();	
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
	public Response deleteInlogpagina(Useraccount useraccount) {
		useraccountService.delete(useraccount);
		return Response.accepted(useraccount.getGebruikersnaam()).build();
	}
}