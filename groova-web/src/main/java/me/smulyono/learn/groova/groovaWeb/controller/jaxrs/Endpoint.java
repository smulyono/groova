package me.smulyono.learn.groova.groovaWeb.controller.jaxrs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.smulyono.learn.groova.groovaApp.service.ServiceScript;
import me.smulyono.learn.groova.groovaWeb.model.Book;

import org.apache.wink.common.model.atom.AtomEntry;
import org.apache.wink.common.model.atom.AtomText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class Endpoint {

	@Autowired
	private ServiceScript serviceScript;
	
	@Path("/json/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> helloWink(@PathParam("name") String name) {
		List<Book> returnValue = new ArrayList<Book>();
		Book newBook = new Book();
		newBook.setName("testBook + " + name + serviceScript.add(10, (int)Math.round(Math.random() * 10)));
		newBook.setDescription("Description for : " + name);
		returnValue.add(newBook);
		return returnValue;
	}
	
	@Path("/atom")
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public AtomEntry getEntry() {
		AtomEntry entry = new AtomEntry();
		entry.setId("http://example.com/entry");
		entry.setTitle(new AtomText("Web Demo"));
		entry.setUpdated(new Date());
		entry.setPublished(new Date());
		return entry;
	}
}
