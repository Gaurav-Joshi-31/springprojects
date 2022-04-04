package com.springboot.workers.crudApi.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudApi.model.Worker;
import com.springboot.workers.crudApi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Autowired
	private WorkerRepository repository;

	public Worker getWorker(int id) {

		try {
			return repository.getWorker(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Worker> getAllWorkers() {
		try {
			return repository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}
	}

	public boolean addWorker(Worker worker) {
		try {
			return repository.add(worker);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmailById(int id, String email) {
		try {
			return repository.update(id, email);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteById(int id) {
		try {
			return repository.delete(id);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
