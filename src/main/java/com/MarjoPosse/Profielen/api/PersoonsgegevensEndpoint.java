package com.MarjoPosse.Profielen.api;

import java.util.*;
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

@Path("persoonsgegevens")
@Component
public class PersoonsgegevensEndpoint {
	
	@Autowired
	private PersoonsgegevensService persoonsgegevensService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Persoonsgegevens> persoonsgegevens = persoonsgegevensService.findAll();
		return Response.ok(persoonsgegevens).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postPersoonsgegevens(Persoonsgegevens persoonsgegevens){
		Persoonsgegevens result = persoonsgegevensService.save(persoonsgegevens);
		return Response.accepted(result.getvoornaam()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putPersoonsgegevens(Persoonsgegevens persoonsgegevens) {
		Persoonsgegevens result1 = persoonsgegevensService.save(persoonsgegevens);
		return Response.accepted(result1.getvoornaam()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteVrijwilligerswerk(Persoonsgegevens persoonsgegevens) {
		persoonsgegevensService.delete(persoonsgegevens);
		return Response.accepted(persoonsgegevens.getvoornaam()).build();
	} 
}
