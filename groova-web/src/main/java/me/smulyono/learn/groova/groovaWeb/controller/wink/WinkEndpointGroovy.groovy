package me.smulyono.learn.groova.groovaWeb.controller.wink


import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

import me.smulyono.learn.groova.groovaWeb.model.Book

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
@Path("/gjson")
class WinkEndpointGroovy {
	
	private Logger logger = LoggerFactory.getLogger(WinkEndpointGroovy.class);
	
	@Path("/{name}")
	@GET
	@Produces("application/json")
	List<Book> helloWinkInGroovy(@PathParam("name") String name){
		logger.debug(">>> Entering Groovy Wink Controller <<<<");
		def returnValue = new ArrayList<Book>(3);
		returnValue.add(new Book(name : "this is new book", description : "description for " + name));
		returnValue.add(new Book(name : "this is new book2", description : "description for " + name));
		returnValue.add(new Book(name : "this is new book3", description : "description for " + name));
		return returnValue;
	}
}
