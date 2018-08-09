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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Path("vragen")
@Component
public class VragenEndpoint {
	
	@Autowired
	private VragenService vragenService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Vragen> vragen = vragenService.findAll();
		return Response.ok(vragen).build();
	}
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id")Long id) {
		if (vragenService.existsById(id)) {
			Vragen vragen=this.vragenService.findById(id);
            return Response.ok(vragen).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postVragen(Vragen vragen){
		Vragen result = vragenService.save(vragen);
		return Response.accepted(result.getVoornaam()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putVragen(Vragen vragen) {
		Vragen result = vragenService.save(vragen);
		return Response.accepted(result.getVoornaam()).build();
	}
	
	@DELETE
	@Consumes (MediaType.APPLICATION_JSON)
	public Response deleteWerkervaring(Vragen vragen) {
		vragenService.delete(vragen);
		return Response.accepted(vragen.getVoornaam()).build();
	}
}
