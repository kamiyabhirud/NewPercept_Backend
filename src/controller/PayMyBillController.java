package controller;

import java.util.List;

import model.PayMyBill;
import model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.PayMyBillDaoImpl;

@RestController
@RequestMapping("/service/paymybill")
public class PayMyBillController {

	@Autowired
	private PayMyBillDaoImpl paymybilldaoimpl;
	private StatusController statuscontrollerobj = new StatusController();

	/*** get allpayment history     ****/
	@RequestMapping(value = "/getpaymybilldetails/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	List<PayMyBill> getpaymenthistorydetails(@PathVariable String username) {
		// User newuser = new User();

		List<PayMyBill> result_paymybilldetails = paymybilldaoimpl.getpaymybill(username);
		return result_paymybilldetails;
	}
	
	/***********paybill details*****/
	@RequestMapping(value = "/makepayment/username/{username}/paymentamt/{paymentamt}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatus(@PathVariable String username,@PathVariable String paymentamt) {
		 Boolean result_notify = paymybilldaoimpl.paybill(username, paymentamt);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
}
