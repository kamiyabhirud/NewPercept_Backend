package dao;

import java.util.List;

import model.PayMyBill;

public interface PayMyBillDao {

	public List<PayMyBill> getpaymybill(String username); 
	
	public Boolean paybill(String username,String paymentamt);
}
