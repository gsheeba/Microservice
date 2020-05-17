package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;

@RestController
public class GreetingRESTController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping(path = "/greet/default", method = RequestMethod.GET)
	public String defaultGreeting() {
		return "Hello " + (new Random()).nextInt();

	}

	@RequestMapping(path = "/greet/{name}"/** ,method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE **/
	)
	public @ResponseBody GreetingViewBean greetComplex(@PathVariable String name) {
		return new GreetingViewBean("Hello", "Mr", name, new Date());
	}

	@RequestMapping(path = "/greet/{id}/{name}")
	public @ResponseBody GreetingViewBean greetfromDb(@PathVariable Integer id, @PathVariable String name) {
		Greeting greeting = greetingService.getGreeting(id);
		if (greeting != null) {
			return new GreetingViewBean(greeting.getGreetText(), "Mr", name, new Date());
		} else {
			return new GreetingViewBean("UNKNOWN", "UNKNOWN", name, new Date());
		}

	}

	@RequestMapping(path = "/greet/all", method = RequestMethod.GET)
	public List<Greeting> getAllGreetings() {
		return greetingService.getAllGreetings();

	}

}