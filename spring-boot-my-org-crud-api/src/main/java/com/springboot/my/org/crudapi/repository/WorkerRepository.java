package com.springboot.my.org.crudapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.WorkerDao;
import com.springboot.my.org.crudapi.mapper.MapMapper;
import com.springboot.my.org.crudapi.mapper.WorkerMapper;
import com.springboot.my.org.crudapi.model.Worker;

@Repository("workerRepo")
public class WorkerRepository implements WorkerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public boolean insertWorker(Worker worker) {
		String sql = "insert into worker values (?,?,?,?,?,?,?)";
		return jdbcTemplateObject.update(sql, worker.getWorkerId(), worker.getfirstName(), worker.getlastName(),
		        worker.getSalary(), worker.getjoiningDate(), worker.getDepartment(), worker.getEmail() ) ==1;
	}

	@Override
	public boolean deleteWorkerById(int workerId) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		return jdbcTemplateObject.update(sql, workerId)>0;
	}

	@Override
	public Worker findWorkerById(int workerId) {
		String sql = "Select * from worker where worker_id=?";
		return jdbcTemplateObject.queryForObject(
				sql, 
				new WorkerMapper(),
				workerId
			);
	}

	@Override
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM worker";
		return jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
	}

	@Override
	public boolean replaceWorker(Worker worker) {
		String sql = "update worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
		return jdbcTemplateObject.update(sql, worker.getfirstName(), worker.getlastName(),
		        worker.getSalary(), worker.getjoiningDate(), worker.getDepartment(), worker.getEmail(), worker.getWorkerId())>0;
	}

	@Override
	public boolean updateWorkerEmailById(int id, String email) {
		String sql = "update worker set email=? where worker_id=?";
		
		return jdbcTemplateObject.update(sql, email, id)>0;
	}

	@Override
	public List<Map<String, String>> getAllDetails() {
		String sql = """
    			select * from 
    			(select * from worker inner join title on worker_id = worker_ref_id) joined left join bonus 
    			on joined.worker_id = bonus.worker_ref_id
    			""";
		return jdbcTemplateObject.query(sql, new MapMapper());
	}

	@Override
	public List<Map<String, String>> getAllDetailsByDept(String dept) {
		String sql = String.format("""
    			select * from 
    			(select * from worker inner join title on worker_id = worker_ref_id
    			where department = "%s") joined left join bonus 
    			on joined.worker_id = bonus.worker_ref_id
    			""",dept);
		return jdbcTemplateObject.query(sql, new MapMapper());
	}

}
