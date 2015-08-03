package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.PaymentHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PaymentHistoryDaoImpl implements PaymentHistoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	@Override
	public List<PaymentHistory> getpaymenthistory(String username) {
		String query = "select distinct h.fkusername,h.customernumber,p.pastdueamount,p.amountdue,p.remainingbalance,h.date,h.doctortype,h.transactionnumber,h.credit,h.debit,h.name,h.description"
				+ " from paymenthistory h,paymentaccounts p where fkusername = 'Tom' and p.username= h.fkusername";
		
		List<PaymentHistory> paymenthistorylist = new ArrayList<PaymentHistory>();

		List<Map<String, Object>> paymenthistorynewrow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> paymentrow : paymenthistorynewrow) {
			PaymentHistory newpaymenthistoryrow = new PaymentHistory();

			newpaymenthistoryrow.setUsername(String.valueOf(paymentrow.get("username")));
			newpaymenthistoryrow.setCustomernumber(String.valueOf(paymentrow.get("customernumber")));
			newpaymenthistoryrow.setPastdueamount(String.valueOf(paymentrow.get("pastdueamount")));
			newpaymenthistoryrow.setAmountdue(String.valueOf(paymentrow.get("amountdue")));
			newpaymenthistoryrow.setRemainingbalance(String.valueOf(paymentrow.get("remainingbalance")));
			newpaymenthistoryrow.setDate(String.valueOf(paymentrow.get("date")));
			newpaymenthistoryrow.setDoctortype(String.valueOf(paymentrow.get("doctortype")));
			newpaymenthistoryrow.setTransactionnumber(String.valueOf(paymentrow.get("transactionnumber")));
			newpaymenthistoryrow.setCredit(String.valueOf(paymentrow.get("credit")));
			newpaymenthistoryrow.setDebit(String.valueOf(paymentrow.get("debit")));
			newpaymenthistoryrow.setName(String.valueOf(paymentrow.get("name")));
			newpaymenthistoryrow.setDescription(String.valueOf(paymentrow.get("description")));
			paymenthistorylist.add(newpaymenthistoryrow);
		}

		return paymenthistorylist;
	}
}
