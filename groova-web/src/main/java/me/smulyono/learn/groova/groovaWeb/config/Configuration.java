package me.smulyono.learn.groova.groovaWeb.config;

import java.util.HashSet;
import java.util.Set;

import me.smulyono.learn.groova.groovaApp.config.ConfigClass;

import org.apache.wink.spring.Registrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "me.smulyono.learn.groova.groovaWeb")
@Import({ConfigClass.class})
@ImportResource({ 
		"/WEB-INF/configs/wink-core-context.xml"
		})
public class Configuration {
	@Autowired
	private ApplicationContext context;
	
	/**
	 * Configuration for Wink Implementation JAX-RS
	 * @return
	 */
	@Bean
	public Registrar getRegistrar() {
		Registrar newBean = new Registrar();
		Set<Object> winkResources = new HashSet<Object>(2);
		winkResources.add(context.getBean("endpoint"));
		winkResources.add(context.getBean("endpointGroovy"));

		newBean.setInstances(winkResources);

		return newBean;
	}
	
}
