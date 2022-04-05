package com.springboot.my.org.crudapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.TitleDao;
import com.springboot.my.org.crudapi.mapper.TitleMapper;
import com.springboot.my.org.crudapi.model.Title;

@Repository("titleRepo")
public class TitleRepository implements TitleDao {

	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public boolean insertTitle(Title title) {
		String sql = "insert into title values (?,?,?)";
		return jdbcTemplateObject.update(sql, title.getWorkerRefId(), title.getWorkerTitle(),
				title.getAffectedFrom()) > 0;
	}

	@Override
	public boolean deleteTitleById(int workerRefId) {
		String sql = "delete from title where worker_ref_id=" + workerRefId + " order by affected_from desc limit 1";
		return jdbcTemplateObject.update(sql) > 0;
	}

	@Override
	public Title findTitleById(int workerRefId) {
		String sql = "select * from title where worker_ref_id=" + workerRefId;
		return jdbcTemplateObject.queryForObject(sql, new TitleMapper());
	}

	@Override
	public List<Title> findTitleByDept(String dept) {
		String sql = String.format("""
				select worker_id, worker_title, affected_from
				from worker inner join title
				on worker_id = worker_ref_id
				where department = "%s"
							""", dept);

		return jdbcTemplateObject.query(sql, new TitleMapper());
	}

	@Override
	public List<Title> findAllTitles() {
		String sql = "select * from title";
		return jdbcTemplateObject.query(sql, new TitleMapper());
	}

	@Override
	public boolean replaceTitle(Title title) {
		String update = "update title set worker_title=?, affected_from=? where worker_ref_id=?";
		return jdbcTemplateObject.update(update, title.getWorkerTitle(), title.getAffectedFrom(),
				title.getWorkerRefId()) > 0;
	}

	@Override
	public boolean createTitleById(int id, String title) {
		String update = "insert into title values (?,?,?)";
		return jdbcTemplateObject.update(update, id, title, new Date(System.currentTimeMillis())) > 0;
	}

}
