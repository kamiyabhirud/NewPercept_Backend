package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.AutomaticPayment;
import model.Status;
import model.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AutomaticPaymentDaoImpl implements AutomaticPaymentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	/********** Get User Profile Details  **********/
	@Override
	public AutomaticPayment getautopaydetails(String username){
	
		String query = "select accountdetails,frequency,startday from paymentaccounts where autopay = 'yes' and  username = ? and deleted = 'no' ";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		AutomaticPayment autopaydetails = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<AutomaticPayment>() {
					@Override
					public AutomaticPayment mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						AutomaticPayment autopayobj = new AutomaticPayment();
						autopayobj.setAutopayaccountnumber(rs.getString("accountdetails"));
						autopayobj.setAutopayfrequency(rs.getString("frequency"));
						autopayobj.setAutopaystartday(rs.getString("startday"));
						return autopayobj;
					}
				});
		return autopaydetails;

	}
	
//	@Override
//	public Boolean putautopayaccount( String frequency, String startday,String autopayaccount, String username){
//	
//		 AutomaticPayment automaticpayment = new AutomaticPayment();
//		String query = "update paymentaccounts set autopay = 'yes' , frequency ='"+frequency+"' , startday ='"+startday+"' where accountdetails ='"+autopayaccount
//				+"' and username = '"+username+"'";
//		Object[] args = new Object[] { automaticpayment.getAutopayaccountnumber(),
//				automaticpayment.getAutopayfrequency(), automaticpayment.getAutopaystartday()};
//
//		int out = jdbcTemplate.update(query, args);
//		if(out!=0){
//			return true;
//		}else {
//			return false;
//		}
		

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
//		AutomaticPayment autopaydetails = jdbcTemplate.queryForObject(query,
//				new Object[] { username }, new RowMapper<AutomaticPayment>() {
//					@Override
//					public AutomaticPayment mapRow(ResultSet rs, int rowNum)
//							throws SQLException {
//						AutomaticPayment autopayobj = new AutomaticPayment();
//						autopayobj.setAutopayaccountnumber(rs.getString("accountdetails"));
//						autopayobj.setAutopayfrequency(rs.getString("frequency"));
//						autopayobj.setAutopaystartday(rs.getString("startday"));
//						return autopayobj;
//					}
//				});
//		return autopaydetails;
	
	@Override
	public Boolean putautopayaccount(AutomaticPayment automaticpayment){
	
		 
		String query = "update paymentaccounts set autopay = 'yes' , frequency = ?, startday = ? where accountdetails = ? and username = 'Tom' ";
		Object[] args = new Object[] {automaticpayment.getAutopayfrequency(), automaticpayment.getAutopaystartday(), automaticpayment.getAutopayaccountnumber(),};

		int out = jdbcTemplate.update(query, args);
		if(out!=0){
			String deletequery = "update paymentaccounts set autopay = 'no' where username = 'Tom'";
			jdbcTemplate.update(deletequery);
//			String queryagain = "update paymentaccounts set autopay = 'yes' , frequency = ?, startday = ? where accountdetails = ? and username = 'Tom' ";
//			Object[] argsagain = new Object[] {automaticpayment.getAutopayfrequency(), automaticpayment.getAutopaystartday(), automaticpayment.getAutopayaccountnumber(),};
			jdbcTemplate.update(query, args);
			return true;
		}else {
			return false;
		}

	}
	
}
