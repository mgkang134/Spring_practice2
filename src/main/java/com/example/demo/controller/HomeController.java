package com.example.demo.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		Logger log= org.slf4j.LoggerFactory.getLogger(getClass());
		log.info("home controller");
		return "home";
		
		
	}
	
}
