package me.smulyono.learn.groova.groovaWeb.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping("/")
	public String indexPage(ModelMap model, HttpServletResponse resp){
		logger.info("index page");
		model.addAttribute("title", "Groova WEB");
		return "index";
	}
}
