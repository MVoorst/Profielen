package com.MarjoPosse.Profielen.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Path("inlogpagina")
@Component
public class InlogpaginaEndpoint {
	
	@Autowired
	private InlogpaginaService inlogpaginaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Inlogpagina> inlogpagina = inlogpaginaService.findAll();
		return Response.ok(inlogpagina).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postWerkervaring(Inlogpagina inlogpagina){
		Inlogpagina result = inlogpaginaService.save(inlogpagina);
		return Response.accepted(result.getGebruikersnaam()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putInlogpagina(Inlogpagina inlogpagina) {
		Inlogpagina result = inlogpaginaService.save(inlogpagina);
		return Response.accepted(result.getGebruikersnaam()).build();
	}
	
	@DELETE
	@Consumes (MediaType.APPLICATION_JSON)
	public Response deleteInlogpagina(Inlogpagina inlogpagina) {
		inlogpaginaService.delete(inlogpagina);
		return Response.accepted(inlogpagina.getGebruikersnaam()).build();
	}
}