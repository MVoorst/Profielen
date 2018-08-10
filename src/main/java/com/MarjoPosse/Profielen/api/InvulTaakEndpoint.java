package com.MarjoPosse.Profielen.api;

import java.util.*;

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

@Path("invultaak")
@Component
public class InvulTaakEndpoint {
	
	@Autowired
	private InvulTaakService invultaakService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <InvulTaak> invultaak = invultaakService.findAll();
		return Response.ok(invultaak).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInvulTaakById(@PathParam("id")Long id) {
		Optional<InvulTaak> optionalinvultaak=this.invultaakService.findById(id);
		if (invultaakService.existsById(id)){
			Optional<InvulTaak> invultaak = invultaakService.findById(id);
			 return Response.ok(invultaak).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postInvulTaak(InvulTaak invultaak){
		
		InvulTaak result = invultaakService.save(invultaak);
		return Response.accepted(result.getId()).build();	
	}
	
	@POST
	@Path("invul")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postinvullen(InvulTaak invul) {
		
		return Response.ok(invultaak);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putinvultaak(InvulTaak invultaak) {
		InvulTaak result1 = invultaakService.save(invultaak);
		return Response.accepted(result1.getId()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteVrijwilligerswerk(InvulTaak invultaak) {
		invultaakService.delete(invultaak);
		return Response.accepted(invultaak.getId()).build();
	} 
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <InvulTaak> optionalToBeDeleted = this.invultaakService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.invultaakService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
