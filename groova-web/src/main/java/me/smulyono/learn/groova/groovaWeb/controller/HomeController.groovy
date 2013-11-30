package me.smulyono.learn.groova.groovaWeb.controller

import groovy.json.JsonOutput

import javax.servlet.http.HttpServletResponse

import me.smulyono.learn.groova.groovaWeb.model.Book

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	String show(ModelMap model, HttpServletResponse resp){
		model.addAttribute("title", "Groova WEB Groovy");
		return "index";
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET)
	@ResponseBody
	String showJson(){
		def returnValue = [];
		returnValue.add(new Book(name:"book1", description:"this is book 1"));
		returnValue.add(new Book(name:"book2", description:"this is book 2"));
		returnValue.add(new Book(name:"book3", description:"this is book 3"));
		returnValue.add(new Book(name:"book4", description:"this is book 4"));
		
		return JsonOutput.toJson(returnValue);
	}
}
