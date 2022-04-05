package com.springboot.my.org.crudapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.org.crudapi.model.Bonus;

public class BonusMapper implements RowMapper<Bonus> {

	@Override
	public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Bonus(rs.getInt(1),rs.getInt(2),rs.getDate(3));
	}

}
