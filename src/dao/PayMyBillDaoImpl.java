package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.PayMyBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PayMyBillDaoImpl implements PayMyBillDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	@Override
	public List<PayMyBill> getpaymybill(String username) {
		String query = "select remainingbalance , amountdue , pastdueamount , accountdetails from newperceptdatabase.paymentaccounts "
				+ "where deleted = 'no' and username =  '"+  username +"'";

		List<PayMyBill> paymybilllist = new ArrayList<PayMyBill>();

		List<Map<String, Object>> paymenthistorynewrow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> paymybillrow : paymenthistorynewrow) {
			PayMyBill newpaymybillrow = new PayMyBill();

			newpaymybillrow.setRemainingbalance(String.valueOf(paymybillrow.get("remainingbalance")));
			newpaymybillrow.setAmountdue(String.valueOf(paymybillrow.get("amountdue")));
			newpaymybillrow.setPastdueamount(String.valueOf(paymybillrow.get("pastdueamount")));
			newpaymybillrow.setAccountdetails(String.valueOf(paymybillrow.get("accountdetails")));
			paymybilllist.add(newpaymybillrow);
		}

		return paymybilllist;
	}
	
	/*************make payment account********/
	@Override
	public Boolean paybill(String username,String paymentamt){
		int out = 0 ;
		int outagain = 0;
		int outhistory = 0;
		if (paymentamt.equals("remainingbalance")) {
			String updatequery = "update paymentaccounts set remainingbalance = 0 , amountdue = 0 , pastdueamount = 0 "
					+ "where username = 'Tom'";
			out = jdbcTemplate.update(updatequery);

			String query = "update paymenthistory set remainingbalance = 0, amountdue = 0 , pastdueamount = 0 ";
			outagain = jdbcTemplate.update(query);
			
			String queryhistory = "insert into paymenthistory(fkusername,customernumber,remainingbalance,amountdue,pastdueamount,doctortype,transactionnumber,credit,debit,description) values('Tom','000111222', 0,0,0,'Eye Specialist','xxxx8888','xxx12','0000','Test Report') ";
			outhistory = jdbcTemplate.update(queryhistory);
		} else if (paymentamt.equals("amountdue")) {
			String updatequery = "update paymentaccounts set amountdue = 0 "
					+ "where username = 'Tom'";
			out = jdbcTemplate.update(updatequery);
			String query = "update paymenthistory set amountdue = 0 ";
			outagain = jdbcTemplate.update(query);
			
			String queryhistory = "insert into paymenthistory(fkusername,customernumber,amountdue,doctortype,transactionnumber,credit,debit,description) values('Tom','000111222',0,'Eye Specialist','xxxx8888','xxx12','0000','Test Report') ";
			outhistory = jdbcTemplate.update(queryhistory);
		} else if (paymentamt.equals("pastdueamount")) {
			String updatequery = "update paymentaccounts set pastdueamount = 0 "
					+ "where username = 'Tom'";
			out = jdbcTemplate.update(updatequery);
			String query = "update paymenthistory set pastdueamount = 0 ";
			outagain = jdbcTemplate.update(query);
			
			String queryhistory = "insert into paymenthistory(fkusername,customernumber,pastdueamount,doctortype,transactionnumber,credit,debit,description) values('Tom','000111222',0,'Eye Specialist','xxxx8888','xxx12','0000','Test Report') ";
			outhistory = jdbcTemplate.update(queryhistory);
		}
			
		
			if(out!=0 && outagain!=0){		
			return true;
		}else {
			return false;
		}

	}
}
