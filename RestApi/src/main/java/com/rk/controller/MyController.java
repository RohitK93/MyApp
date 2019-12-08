package com.rk.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping(value="getname",method = RequestMethod.POST)
	public String getname(@RequestBody String request) {
		
		System.out.println("request --->"+request);
		return "My name is ......";
	}
	
}
