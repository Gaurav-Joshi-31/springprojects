package com.springboot.my.org.crudapi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Resource(name="workerRepo")
	WorkerRepository workerRepo;
	
	public Worker getWorker(Integer id) {
			return workerRepo.findWorkerById(id);
	}
	

	public List<Worker> getWorkers() {
		
			return workerRepo.getAllWorkers();
		
	}
	
	public boolean createWorker(Worker worker) {
	
			return workerRepo.insertWorker(worker);
			
	}

	public boolean updateWorker(Integer id, String email) {
		
			return workerRepo.updateWorkerEmailById(id,email);
		
	}

	public boolean deleteWorkerById(Integer id) {
		
			return workerRepo.deleteWorkerById(id);
		
	}
	
	public List<Map<String,String>> getCombinedDetails() {
		
			return workerRepo.getAllDetails();
		
	}
	
	public List<Map<String,String>> getCombinedDetailsByDept(String dept) {
	
			return workerRepo.getAllDetailsByDept(dept);
		
	}
}
