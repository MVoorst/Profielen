package com.MarjoPosse.Profielen.api;

import java.util.*;

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

@Path("cv")
@Component
public class CVEndpoint {
	
	@Autowired
	private CVService cvService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <CV> cv = cvService.findAll();
		return Response.ok(cv).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCVById(@PathParam("id")Long id) {
		Optional<CV> optionalcv=this.cvService.findById(id);
		if (cvService.existsById(id)){
			Optional<CV> persoon = cvService.findById(id);
			 return Response.ok(persoon).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postVrijwilligerswerk(CV cv){
		
		CV result = cvService.save(cv);
		return Response.accepted(result.getNaam()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putcv(CV cv) {
		CV result1 = cvService.save(cv);
		return Response.accepted(result1.getNaam()).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteVrijwilligerswerk(CV cv) {
		cvService.delete(cv);
		return Response.accepted(cv.getNaam()).build();
	} 
}