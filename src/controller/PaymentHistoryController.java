package controller;

import java.util.List;

import model.PaymentHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.PaymentHistoryDaoImpl;

@RestController
@RequestMapping("/service/paymenthistory")
public class PaymentHistoryController {

	@Autowired
	private PaymentHistoryDaoImpl paymenthistorydaoimpl;

	/*** get allpayment history     ****/
	@RequestMapping(value = "/getpaymenthistory/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	List<PaymentHistory> getpaymenthistorydetails(@PathVariable String username) {
		// User newuser = new User();

		List<PaymentHistory> result_doctordetails = paymenthistorydaoimpl.getpaymenthistory(username);
		return result_doctordetails;
	}
	
}
