package com.springboot.workers.crudApi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudApi.model.Worker;


public interface WorkerDao {
        public boolean add(Worker worker)
                        throws SQLException;

        public boolean delete(int workerId)
                        throws SQLException;

        public Worker getWorker(int workerId)
                        throws SQLException;

        public List<Worker> getWorkers()
                        throws SQLException;

        public boolean update(int id,String email)
                        throws SQLException;
}
