package com.MarjoPosse.Profielen.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.api.UseraccountEndpoint;
import com.MarjoPosse.Profielen.api.VoorbeeldEndpoint;
import com.MarjoPosse.Profielen.api.AdminaccountEndpoint;
import com.MarjoPosse.Profielen.api.CVEndpoint;
import com.MarjoPosse.Profielen.api.FeedbackEndpoint;
import com.MarjoPosse.Profielen.api.InvulTaakEndpoint;
import com.MarjoPosse.Profielen.api.VragenlijstEndpoint;
import com.MarjoPosse.Profielen.email.SendEmail;
import com.MarjoPosse.Profielen.api.VraagEndpoint;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(CVEndpoint.class);
		register(VragenlijstEndpoint.class);
		register(AdminaccountEndpoint.class);
		register(UseraccountEndpoint.class);
		register(FeedbackEndpoint.class);
		register(InvulTaakEndpoint.class);
		register(VoorbeeldEndpoint.class);
		register(VraagEndpoint.class);
		register(SendEmail.class);
	}
}
