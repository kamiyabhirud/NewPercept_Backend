package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyPaymentAccountsDaoImpl implements MyPaymentAccountsDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
/*************delete account********/
	@Override
	public Boolean deleteaccount(String acctnumber){

		String deletequery = "update paymentaccounts set deleted = 'yes' where accountdetails = '"+acctnumber+"'";
			int out = jdbcTemplate.update(deletequery);
			if(out!=0){		
			return true;
		}else {
			return false;
		}

	}
	
	/*************edit account********/	
	@Override
	public Boolean editaccount( String expirationmonth, String expirationyear , String acctnumber){
		
		String deletequery = "update paymentaccounts set expirationmonth = '"+expirationmonth+"', expirationyear='"+expirationyear+"'  where accountdetails = '"+acctnumber+"'";
		int out = jdbcTemplate.update(deletequery);
		if(out!=0){		
		return true;
	}else {
		return false;
	}
		}
	
	/********add creditcard details********/
	@Override
	public Boolean addcreditcardaccount(String username, String firstname, String lastname, String creditcardnumber,String expitymonth,String expiryyear,String cvv, String cardtype){
		
		String deletequery = "insert into paymentaccounts(username,firstname,lastname,accountdetails,expirationmonth,expirationyear,cvvnumber,cardtype,deleted,autopay,accounttype) "
				+ "values('"+username+"','"+firstname+"','"+lastname+"','"+creditcardnumber+"','"+expitymonth+"','"+expiryyear+"','"+cvv+"','"+cardtype+"','no','no','creditcard')";
		int out = jdbcTemplate.update(deletequery);
		if(out!=0){		
		return true;
	}else {
		return false;
	}
		}

	/******add checkings account*********/
	@Override
	public Boolean addcheckingsaccount(String username, String firstname, String lastname, String checkingsacctnumber,String routingnumber){
		
		String deletequery =  "insert into paymentaccounts(username,firstname,lastname,accountdetails,routingnumber,deleted,autopay,accounttype) "
				+ "values('"+username+"','"+firstname+"','"+lastname+"','"+checkingsacctnumber+"','"+routingnumber+"','no','no','checkings')";
		int out = jdbcTemplate.update(deletequery);
		if(out!=0){		
		return true;
	}else {
		return false;
	}
		}
	
	/********addsavings account*******/
	@Override
	public Boolean addsavingsaccount(String username, String firstname, String lastname,String checkingsacctnumber,String routingnumber){
		
		String deletequery =  "insert into paymentaccounts(username,firstname,lastname,accountdetails,routingnumber,deleted,autopay,accounttype) "
				+ "values('"+username+"','"+firstname+"','"+lastname+"','"+checkingsacctnumber+"','"+routingnumber+"','no','no','savings')";
		int out = jdbcTemplate.update(deletequery);
		if(out!=0){		
		return true;
	}else {
		return false;
	}
		}
}
