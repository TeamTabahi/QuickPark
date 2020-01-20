package com.spr;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImple implements LoginDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public Login validateUser(Login login) {
	
		
	      	String sql = "select * from Master where UserName=? and Password=?";
		
		
		    Login log1=jdbctemplate.queryForObject(sql, new Object[]{login.getUserName(),login.getPassword()}, new RowMapper<Login>() {

				@Override
				public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
					Login log=new Login();
					log.setUserName(rs.getString(2));
					log.setPassword(rs.getString(3));
					log.setRole(rs.getString(4));
					return log;
				}
		    	
		    	
		    });
			return log1;
		
	}
}
