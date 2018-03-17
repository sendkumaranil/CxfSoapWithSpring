package com.cxfsoap.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SourcesDestinationMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString("sourdest");	
	}
}
