package com.xch.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("form")
public class form {

	
	
	@Path("/submit")
	@POST
	public String getDetails(@FormParam("name") String name , @FormParam("pass") String pass){
		return "Your name is " + name +"<br> and your password is "+pass;
	}
}
