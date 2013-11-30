package me.smulyono.learn.groova.jersey2.application;

import me.smulyono.learn.groova.jersey2.jaxrs.Endpoint;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyApplication extends ResourceConfig {
	public JerseyApplication(){
		register(RequestContextFilter.class);
		register(JacksonFeature.class); // register jackson - json
		//
		register(Endpoint.class);
	}
}
