package dao;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



//import java.sql.ResultSet;
import javax.sql.DataSource;



//import com.mysql.jdbc.Connection;
import model.Login;

/*
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.jdbc.core.support.JdbcDaoSupport;
 import org.springframework.stereotype.Repository; */

//import model.Login;
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}

	public Boolean isAuthorized(String username, String password) {
		// String incorrect = "Incorrect";
		String query = "SELECT username,password FROM login where username = ?";

		Login newlogin = jdbcTemplate.queryForObject(query,new Object[]{username}, new RowMapper<Login>() {

			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				Login newlogin = new Login();
				newlogin.setUsername(rs.getString("username"));
				newlogin.setPassword(rs.getString("password"));

				return newlogin;
			}
		}); 
		
		if (username.equals(newlogin.getUsername()) && password.equals(newlogin.getPassword()))
			return true;
		else
			return false;

	}

}

//
