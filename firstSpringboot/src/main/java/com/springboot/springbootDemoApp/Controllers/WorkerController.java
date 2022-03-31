package com.springboot.springbootDemoApp.Controllers;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootDemoApp.models.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return new Worker(101, "Gaurav", "Joshi", "10000", new Date(System.currentTimeMillis()), "IT",
				"gaurav@gmail.com");
	}

	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return Arrays.asList(
				new Worker(101, "Gaurav", "Joshi", "10000", new Date(System.currentTimeMillis()), "IT",
						"gaurav@gmail.com"),
				new Worker(102, "Sumit", "Joshi", "10000", new Date(System.currentTimeMillis()), "CS",
						"sumit@gmail.com"),
				new Worker(103, "Jeevan", "Joshi", "10000", new Date(System.currentTimeMillis()), "Accounting",
						"jeevan@gmail.com"));
	}

}
