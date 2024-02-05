package com.example.tododemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {

	@GetMapping(path = "/say-hello")
	public String hello() {
		return "Hello!";
	}
	
	@RequestMapping(path = "/say-hello-jsp")
	public String helloJSP() {
		return "hello";
	}
	
}
