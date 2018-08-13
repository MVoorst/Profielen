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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

@Path("vragenlijst")
@Component
public class VragenlijstEndpoint {
	
	@Autowired
	private VragenlijstService vragenlijstService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Vragenlijst> vragenlijst = vragenlijstService.findAll();
		return Response.ok(vragenlijst).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVragenById(@PathParam("id")Long id) {
		Optional<Vragenlijst> optionalvragen=this.vragenlijstService.findById(id);
		if (vragenlijstService.existsById(id)){
			Optional<Vragenlijst> vragenlijst = vragenlijstService.findById(id);
			 return Response.ok(vragenlijst).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postVragen(Vragenlijst vragen){
		Vragenlijst result = vragenlijstService.save(vragen);
		return Response.accepted(result.getVraag1()).build();	
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putVragen(Vragenlijst vragen) {
		Vragenlijst result = vragenlijstService.save(vragen);
		return Response.accepted(result.getVraag1()).build();
	}
	
	@DELETE
	@Consumes (MediaType.APPLICATION_JSON)
	public Response delete(Vragenlijst vragenlijst) {
		vragenlijstService.delete(vragenlijst);
		return Response.accepted(vragenlijst.getVraag1()).build();
	}
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional<Vragenlijst> optionalToBeDeleted = this.vragenlijstService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.vragenlijstService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}