package com.springboot.my.org.crudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDao;
import com.springboot.my.org.crudapi.mapper.BonusMapper;
import com.springboot.my.org.crudapi.model.Bonus;

@Repository("bonusRepo")
public class BonusRepository implements BonusDao {
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	@Override
	public boolean addBonus(Bonus bonus) {
		String sql = "insert into bonus values (?,?,?)";
		return jdbcTemplateObject.update(sql,bonus.getWorkerRefId(),bonus.getBonusAmount(),bonus.getBonusDate())==1;
	}

	@Override
	public boolean deleteBonusById(int workerRefId) {
		String sql = "delete from bonus where worker_ref_id=" + workerRefId + " order by bonus_date desc limit 1";
		return jdbcTemplateObject.update(sql)>0;
	}

	@Override
	public Bonus findBonusById(int workerRefId) {
		String sql = "select * from bonus where worker_ref_id="+workerRefId;
		return jdbcTemplateObject.queryForObject(sql, new BonusMapper());
	}

	@Override
	public List<Bonus> findBonusByDept(String dept) {
		String sql = String.format("""
    			select worker_ref_id,
    			bonus_amount,
    			bonus_date from worker inner join bonus
    			on worker_id = worker_ref_id 
    			where department = "%s"
    			""",dept);
		return jdbcTemplateObject.query(sql, new BonusMapper());
	}

	@Override
	public List<Bonus> findAllBonus() {
		String sql = "select * from bonus";
		return jdbcTemplateObject.query(sql, new BonusMapper());
	}

	@Override
	public boolean replaceBonus(Bonus bonus) {
		String update = "update bonus set bonus_amount=?, bonus_date=? where worker_ref_id=?";
		return jdbcTemplateObject.update(update,bonus.getBonusAmount(),bonus.getBonusDate(),bonus.getWorkerRefId())>0;
	}

}
