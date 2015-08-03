package controller;

import model.AutomaticPayment;
import model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.AutomaticPaymentDaoImpl;

@RestController
@RequestMapping("/service/autopayment")
public class AutomaticPaymentController {

	@Autowired
	private AutomaticPaymentDaoImpl automaticpaymentdaoimpl;
	private StatusController statuscontrollerobj = new StatusController();

	/*** Get User Profile details     ****/
	@RequestMapping(value = "/getautopaymentdetails/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	AutomaticPayment getusernameprofile(@PathVariable String username) {
		AutomaticPayment result_autopay = automaticpaymentdaoimpl.getautopaydetails(username);
		return result_autopay;
	}
	
	/***********set auotpay details*****/
	@RequestMapping(value = "/setautopayaccount/frequency/{frequency}/startday/{startday}/autopayaccount/{autopayaccount}", method = RequestMethod.GET)
//	public @ResponseBody
//	Status getCredentials(@PathVariable String frequency,@PathVariable String startday,@PathVariable String autopayaccount,@PathVariable String username) {
//	 Boolean result = automaticpaymentdaoimpl.putautopayaccount(frequency,startday,autopayaccount,username);
//	 System.out.println("result------->>>>>>>>>>>>>>>"+result);
//	 Status validity = statuscontrollerobj.isValid(result);
//	 return validity;	
	 
	 public @ResponseBody
	 Status getCredentials(@PathVariable String frequency,@PathVariable String startday,@PathVariable String autopayaccount) {
		AutomaticPayment autopayment = new AutomaticPayment(frequency, startday, autopayaccount);
		
		 Boolean result_notify = automaticpaymentdaoimpl.putautopayaccount(autopayment);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
	
}
