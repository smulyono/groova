package me.smulyono.learn.groova.jersey2.model

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class Account{ 
	@XmlElement String name;
	@XmlElement String email;
	
	def Account(){}
	
	def Account(String name, String email){
		this.name = name;
		this.email = email;
	}
}
