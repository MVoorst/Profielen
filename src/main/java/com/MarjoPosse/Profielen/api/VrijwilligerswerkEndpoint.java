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

@Path("vrijwilligerswerk")
@Component
public class VrijwilligerswerkEndpoint {
	
	@Autowired
	private VrijwilligerswerkService vrijwilligerswerkService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Vrijwilligerswerk> vrijwilligerswerk = vrijwilligerswerkService.findAll();
		return Response.ok(vrijwilligerswerk).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postVrijwilligerswerk(Vrijwilligerswerk vrijwilligerswerk){
		
		Vrijwilligerswerk result = vrijwilligerswerkService.save(vrijwilligerswerk);
		return Response.accepted(result.getNaam()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putVrijwilligerswerk(Vrijwilligerswerk vrijwilligerswerk) {
		Vrijwilligerswerk result1 = vrijwilligerswerkService.save(vrijwilligerswerk);
		return Response.accepted(result1.getNaam()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteVrijwilligerswerk(Vrijwilligerswerk vrijwilligerswerk) {
		vrijwilligerswerkService.delete(vrijwilligerswerk);
		return Response.accepted(vrijwilligerswerk.getNaam()).build();
	} 
}