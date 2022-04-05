package com.springboot.my.org.crudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.util.Utils;

@RestController
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "Hello visitor!</br>Visiting time: "+Utils.getCurrentTimeStamp();
	}
}
