package me.smulyono.learn.groova.groovaApp;

import me.smulyono.learn.groova.groovaApp.config.ConfigClass;
import me.smulyono.learn.groova.groovaApp.service.ServiceHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApplication {
	public static Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	private static ServiceHolder holder;
	
	public static void main(String[] args){
		logger.debug(">>> Enter Application <<<");
		AbstractApplicationContext springContext = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		holder = (ServiceHolder) springContext.getBean("serviceHolder");
		
		logger.info("Multiply 3 * 5 = " + holder.Multiply(3,5));
		
		springContext.close();
	}
}
