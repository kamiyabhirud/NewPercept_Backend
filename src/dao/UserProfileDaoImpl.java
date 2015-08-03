package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import model.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	/********** Get User Profile Details  **********/
	@Override
	public UserProfile getuserprofile(String username){
	
		String query = "select fkusername, firstname, lastname, email, phonenumber, preferredcontact, mailingaddress "
				+ "from userdetails where fkusername = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		UserProfile userprofiledata = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<UserProfile>() {
					@Override
					public UserProfile mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserProfile userprofileobj = new UserProfile();
						userprofileobj.setUsername(rs.getString("fkusername"));
						userprofileobj.setFirstname(rs.getString("firstname"));
						userprofileobj.setLastname(rs.getString("lastname"));
						userprofileobj.setEmail(rs.getString("email"));
						userprofileobj.setPhonenumber(rs.getString("phonenumber"));
						userprofileobj.setPreferredcontact(rs.getString("preferredcontact"));
						userprofileobj.setMailingaddress(rs.getString("mailingaddress"));
						
						return userprofileobj;
					}
				});
		return userprofiledata;

	}
	
	/********** Update User preferred contact  **********/
	/**@Override
	public Boolean updatepreferredcontact(String preferredcontact, String email, String phonenumber, String username){
	
		String query = "update userdetails set preferredcontact = ? and email = ? and phonenumber = ? where fkusername = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		UserProfile userprofiledata = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<UserProfile>() {
					@Override
					public UserProfile mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserProfile userprofileobj = new UserProfile();
						userprofileobj.setUsername(rs.getString("fkusername"));
						userprofileobj.setFirstname(rs.getString("firstname"));
						userprofileobj.setLastname(rs.getString("lastname"));
						userprofileobj.setEmail(rs.getString("email"));
						userprofileobj.setPhonenumber(rs.getString("phonenumber"));
						userprofileobj.setPreferredcontact(rs.getString("preferredcontact"));
						userprofileobj.setMailingaddress(rs.getString("mailingaddress"));
						
						return userprofileobj;
					}
				});
//		return userprofiledata;
		
		if (username.equals(userprofiledata.getPreferredcontact()) 
		 && email.equals(userprofiledata.getEmail()) 
		 && phonenumber.equals(userprofiledata.getPhonenumber())
		 && username.equals(userprofiledata.getUsername()) )
			return true;
		else
			return false;

	}**/
	@Override
	public Boolean updatepreferredcontact(UserProfile userprofile){
	
		String query = "update userdetails set preferredcontact = ? and email = ? and phonenumber = ? where fkusername = ?";
		Object[] args = new Object[] { userprofile.getPreferredcontact(), userprofile.getEmail(),
									   userprofile.getPhonenumber(), userprofile.getUsername() };
		int rowsaffected = jdbcTemplate.update(query, args);
		
		if(rowsaffected !=0 )
		{
			 return true;
		} else{
			return false;
		}
		
	}
}