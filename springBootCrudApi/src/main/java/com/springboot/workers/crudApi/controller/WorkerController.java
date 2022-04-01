package com.springboot.workers.crudApi.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudApi.model.Worker;
import com.springboot.workers.crudApi.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository repository;

	@GetMapping("/worker/{id}")
	public Worker showWorker(@PathVariable int id) {
		try {
			return repository.getWorker(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Worker> showWorkers() {
		try {
			return repository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Worker worker) {
		try {
			return repository.add( worker);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@PatchMapping("/update/{id}")
	public boolean update(@PathVariable int id, @RequestBody Map<String,String> map) {
		try {
			return repository.update(id,map.get("email"));
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		try {
			return repository.delete(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
