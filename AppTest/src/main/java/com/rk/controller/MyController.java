package com.rk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {

	//http://localhost:8080/test
	@RequestMapping(value="test",method = RequestMethod.GET)
	public ModelAndView test() {
		System.out.println("hi");
		
		ModelAndView modelAndView = new ModelAndView("test");
		modelAndView.addObject("message", "My first JSP");
		return modelAndView;
	}
	
	@RequestMapping(value="apicall",method = RequestMethod.GET)
	public ModelAndView apicall() {
		System.out.println("hi");
		
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("id", "1");
		    
		  RestTemplate restTemplate = new RestTemplate();
		  String uri = "http://localhost:8081/getname";
		  ResponseEntity<String> result = restTemplate.postForEntity(uri, params, String.class);
		  
		  String name = result.getBody();
		  ModelAndView modelAndView = new ModelAndView("result");
		  modelAndView.addObject("name", name);
			
		return modelAndView;
	}
}
