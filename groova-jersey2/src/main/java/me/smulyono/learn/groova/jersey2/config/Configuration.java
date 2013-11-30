package me.smulyono.learn.groova.jersey2.config;

import me.smulyono.learn.groova.groovaApp.config.ConfigClass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages="me.smulyono.learn.groova.jersey2.jaxrs")
@Import({ConfigClass.class})
public class Configuration {}
