package com.springboot.springbootDemoApp.Controllers;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Hello Visitor!<br>Visiting Time: "+new Timestamp(System.currentTimeMillis());
	}
}
