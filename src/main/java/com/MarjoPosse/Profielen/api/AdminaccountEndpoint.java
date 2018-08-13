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
import com.MarjoPosse.Profielen.Message.Message;
import com.MarjoPosse.Profielen.controller.*;

@Path("adminaccount")
@Component
public class AdminaccountEndpoint {
	
	@Autowired
	private AdminaccountService adminaccountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Adminaccount> adminaccount = adminaccountService.findAll();
		return Response.ok(adminaccount).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdminaccountById(@PathParam("id")Long id) {
		Optional<Adminaccount> optionaladminaccount=this.adminaccountService.findById(id);
		if (adminaccountService.existsById(id)){
			Optional<Adminaccount> adminaccount = adminaccountService.findById(id);
			 return Response.ok(adminaccount).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAdminaccount(Adminaccount adminaccount){
		Adminaccount result = adminaccountService.save(adminaccount);
		return Response.accepted(result.getGebruikersnaam()).build();
	}
	
	@POST
	@Path("Login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(Adminaccount admin) {
		if (admin == null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		} else {
			if (adminaccountService.loginCheck(admin) == true) {
				return Response.accepted(new Message("Success")).build();
			} else {
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteVrijwilligerswerk(Adminaccount adminaccount) {
		adminaccountService.delete(adminaccount);
		return Response.accepted(adminaccount.getId()).build();
	} 
}
