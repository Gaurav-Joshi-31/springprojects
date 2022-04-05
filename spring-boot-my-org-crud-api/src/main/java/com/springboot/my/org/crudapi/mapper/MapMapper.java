package com.springboot.my.org.crudapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class MapMapper implements RowMapper<Map<String,String>>{

	@Override
	public Map<String, String> mapRow(ResultSet res, int rowNum) throws SQLException {
		Map<String,String> map=new HashMap<>();
		map.put("workerId", ""+res.getInt("worker_id"));
		map.put("firstName", res.getString("first_name"));
		map.put("lastName", res.getString("last_name"));
		map.put("salary",""+res.getInt("salary"));
		map.put("joiningDate", res.getDate("joining_date")+"");
		map.put("dept", res.getString("department"));
		map.put("email", res.getString("email"));
		map.put("workerTitle", res.getString("worker_title"));
		map.put("affectedFrom",res.getDate("affected_from")+"");
		map.put("bonusAmount", res.getInt("bonus_amount")+"");
		map.put("bonusDate", res.getDate("bonus_date")+"");
		return map;
	}

}
