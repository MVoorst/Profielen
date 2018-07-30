package com.MarjoPosse.Profielen.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.domein.*;
import com.MarjoPosse.Profielen.controller.*;

@Path("profielen")
@Component
public class WerkervaringEndpoint {
	
	@Autowired
	private ProfielenService profielenService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Werkervaring> werkervaringen = profielenService.findAll();
		return Response.ok(werkervaringen).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postWerkervaring(Werkervaring werkervaring){
		Werkervaring result = profielenService.save(werkervaring);
		return Response.accepted(result.getId()).build();	
	}
}
