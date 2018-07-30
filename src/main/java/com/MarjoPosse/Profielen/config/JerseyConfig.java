package com.MarjoPosse.Profielen.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.MarjoPosse.Profielen.api.WerkervaringEndpoint;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(WerkervaringEndpoint.class);
	}
}
