package com.MarjoPosse.Profielen.api;

import java.util.Optional;

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

import com.MarjoPosse.Profielen.controller.repository.VraagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

@Path("vraag")
@Component
public class VraagEndpoint {
	
	@Autowired
	private VraagService vraagService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Vraag> vraag = vraagService.findAll();
		return Response.ok(vraag).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVragenById(@PathParam("id")Long id) {
		Optional<Vraag> optionalvragen=this.vraagService.findById(id);
		if (vraagService.existsById(id)){
			Optional<Vraag> vraag = vraagService.findById(id);
			 return Response.ok(vraag).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postVragen(Vraag vraag){
		Vraag result = vraagService.save(vraag);
		return Response.ok(vraag).build();	
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putVragen(Vraag vraag) {
		Vraag result = vraagService.save(vraag);
		return Response.ok(vraag).build();
	}

	
	@DELETE
	@Consumes (MediaType.APPLICATION_JSON)
	public Response delete(Vraag vraag) {
		vraagService.delete(vraag);
		return Response.ok(vraag).build();
	}
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional<Vraag> optionalToBeDeleted = this.vraagService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.vraagService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}