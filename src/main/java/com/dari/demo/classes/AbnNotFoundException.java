package com.dari.demo.classes;

public class AbnNotFoundException extends RuntimeException {

	
	public AbnNotFoundException(long Id){
		 super("Could not find Abn " + Id);
	}
}
