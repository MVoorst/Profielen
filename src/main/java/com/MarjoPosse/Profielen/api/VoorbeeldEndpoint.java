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

import com.MarjoPosse.Profielen.controller.repository.VoorbeeldenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;

@Path("voorbeeld")
@Component

public class VoorbeeldEndpoint {
	
	@Autowired
	private VoorbeeldenService voorbeeldenService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Voorbeelden> voorbeeld = voorbeeldenService.findAll();
		return Response.ok(voorbeeld).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVoorbeeldById(@PathParam("id")Long id) {
		Optional<Voorbeelden> optionalvoorbeeld=this.voorbeeldenService.findById(id);
		if (voorbeeldenService.existsById(id)){
			Optional<Voorbeelden> voorbeelden = voorbeeldenService.findById(id);
			 return Response.ok(voorbeelden).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postInvulTaak(Voorbeelden voorbeeld){
		
		Voorbeelden result = voorbeeldenService.save(voorbeeld);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putvoorbeeld(Voorbeelden voorbeeld) {
		Voorbeelden result1 = voorbeeldenService.save(voorbeeld);
		return Response.accepted(result1.getId()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response delete(Voorbeelden voorbeeld) {
		voorbeeldenService.delete(voorbeeld);
		return Response.accepted(voorbeeld.getId()).build();
	} 
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <Voorbeelden> optionalToBeDeleted = this.voorbeeldenService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.voorbeeldenService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}