package com.springboot.springbootDemoApp.Controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

	@GetMapping("/showMyInfo")
	public HashMap<String, String> getPersonalInfo() {
		HashMap<String, String> map = new HashMap<>();
		map.put("Name", "Gaurav");
		map.put("City", "Haldwani");
		map.put("State", "Uttarakhand");
		map.put("Dream Job", "SDE");

		return map;
	}
	
	@GetMapping("/showMyHobbies")
	public List<String> showHobbies(){
		return Arrays.asList("Cricket","Video Games","Movies");
	}
}
