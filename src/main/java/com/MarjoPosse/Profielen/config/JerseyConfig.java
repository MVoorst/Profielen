package com.MarjoPosse.Profielen.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.api.InlogpaginaEndpoint;
import com.MarjoPosse.Profielen.api.PersoonsgegevensEndpoint;
import com.MarjoPosse.Profielen.api.VrijwilligerswerkEndpoint;
import com.MarjoPosse.Profielen.api.WerkervaringEndpoint;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(VrijwilligerswerkEndpoint.class);
		register(WerkervaringEndpoint.class);
		register(PersoonsgegevensEndpoint.class);
		register(InlogpaginaEndpoint.class);
	}
}
