package me.smulyono.learn.groova.groovaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceHolder {
	@Autowired ServiceScript script;
	
	public int Multiply(int x, int y){
		int returnValue = 0;
		for (int i=0;i<(y/2); i++){
			returnValue += script.add(x, x);
		}
		if (y % 2 > 0){
			returnValue = script.add(returnValue, x);
		}
		return returnValue;
	}
}
