package dao;

import java.util.List;

import model.PaymentHistory;


public interface PaymentHistoryDao {

	public List<PaymentHistory> getpaymenthistory(String username); 
}
