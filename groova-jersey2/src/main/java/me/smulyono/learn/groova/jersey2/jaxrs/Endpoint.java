package me.smulyono.learn.groova.jersey2.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.smulyono.learn.groova.groovaApp.service.ServiceScript;
import me.smulyono.learn.groova.jersey2.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class Endpoint {
	
	@Autowired ServiceScript serviceScript;
	
	@GET
	@Path("/json/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> showAllAccount(@PathParam("description") String desc){
		List<Account> returnValue = new ArrayList<Account>(2);
		returnValue.add(new Account("account " + serviceScript.add(1, 1) , "account@one.com " + desc));
		returnValue.add(new Account("account " + serviceScript.add(2, 1) , "account@two.com"  + desc));
		return returnValue;
	}
	
	@GET
	@Path("/xml/{description}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Account> showXMLaccounts(@PathParam("description") String desc){
		List<Account> returnValue = new ArrayList<Account>(2);
		returnValue.add(new Account("account " + serviceScript.add(1, (int)Math.round(Math.random() * 5)) , "account@one.com " + desc));
		returnValue.add(new Account("account " + serviceScript.add(1, (int)Math.round(Math.random() * 5)) , "account@two.com"  + desc));
		return returnValue;
	}
	
	
	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("name") String name){
		return "Hello " + name;
	}
}
