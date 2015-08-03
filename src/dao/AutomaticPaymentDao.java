package dao;

import model.AutomaticPayment;
import model.Status;


public interface AutomaticPaymentDao {

	public AutomaticPayment getautopaydetails(String username);
	
	public Boolean putautopayaccount(AutomaticPayment automaticpayment);
//	public Boolean putautopayaccount(String frequency, String startday, String autopayaccount,String username);
}
