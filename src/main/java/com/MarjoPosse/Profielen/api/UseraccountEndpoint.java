package com.MarjoPosse.Profielen.api;

import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
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

import com.MarjoPosse.Profielen.Message.Message;
import com.MarjoPosse.Profielen.controller.UseraccountService;
import com.MarjoPosse.Profielen.domein.Useraccount;
import com.MarjoPosse.Profielen.email.SendEmail;

@Path("useraccount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class UseraccountEndpoint {
	
	@Autowired
	private UseraccountService useraccountService;

	@Autowired
	private SendEmail sendEmail;
	
	@GET
	public Response list(){
		return Response.ok(this.useraccountService.findAll()).build();
	}
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id")Long id) {
		Optional<Useraccount> optionaluseraccount=this.useraccountService.findById(id);
		if (optionaluseraccount.isPresent()){
			Useraccount useraccount = optionaluseraccount.get();
			 return Response.ok(useraccount).build();
			}
		return Response.status(Status.NOT_FOUND).build();
		}	

	@POST
	public Response create(Useraccount login) {	
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sbGeneratedPassword = new StringBuilder();
		Random random = new Random();
	    for (int i = 0; i < 6; i++) {
	        sbGeneratedPassword.append(characters.charAt(random.nextInt(characters.length())));
	     }
		login.setWachtwoord(sbGeneratedPassword.toString());  
		useraccountService.save (login);
		try {
			sendEmail.sendEmail(login.getEmailadres(),"Welkom bij Qien","Beste "+login.getVoornaam()+",\nEr is een account aangemaakt voor u.\nDit is uw wachtwoord: "+sbGeneratedPassword+".\nSucces met het invullen van de vragen.\n\nGroet,\nQien BV");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return Response.accepted(login).build();

	}
				
	@POST
	@Path("Login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(Useraccount user) {
		if (user == null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		} else {
			if (useraccountService.loginCheck(user) == true) {
				return Response.accepted(new Message("Success")).build();
			} else {
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
	}
	
	@PUT	//by Marjolijn :)
	@Path("naw")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putVragen(Useraccount user) {
		Useraccount result = useraccountService.save(user);
		return Response.accepted(result.getId()).build();
	}
	

	
	@DELETE
	public Response deleteInlogpagina(Useraccount useraccount) {
		useraccountService.delete(useraccount);
		return Response.accepted(useraccount.getGebruikersnaam()).build();
	}
	
	@DELETE //toegevoegd door Cris
	@Path("{id}")
	public Response deleteById(@PathParam("id") Long id) {
		Optional <Useraccount> optionalToBeDeleted = this.useraccountService.findById(id);

		if(optionalToBeDeleted.isPresent()) {
			this.useraccountService.deleteById(id); 
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}