package controller;
import model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.MyPaymentAccountsDaoImpl;
@RestController
@RequestMapping("/service/mypaymentaccounts")
public class MyPaymentAccountsController {

	@Autowired
	private MyPaymentAccountsDaoImpl mypaymentaccountsdaoimpl;
	private StatusController statuscontrollerobj = new StatusController();

	
	/***********delete account details*****/
	@RequestMapping(value = "/deleteaccount/acctnumber/{acctnumber}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatus(@PathVariable String acctnumber) {
		 Boolean result_notify = mypaymentaccountsdaoimpl.deleteaccount(acctnumber);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
	/***********edit account details*****/
	@RequestMapping(value = "/editaccount/expirationmonth/{expirationmonth}/expirationyear/{expirationyear}/acctnumber/{acctnumber}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatus(@PathVariable String expirationmonth,@PathVariable String expirationyear,@PathVariable String acctnumber) {
		 Boolean result_notify = mypaymentaccountsdaoimpl.editaccount(expirationmonth,expirationyear,acctnumber);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
	/***********add creditcard account details*****/
	@RequestMapping(value = "/addcreditcardaccount/username/{username}/firstname/{firstname}/lastname/{lastname}/accountdetails/{accountdetails}/expirationmonth/{expirationmonth}/expirationyear/{expirationyear}/cvvnumber/{cvvnumber}/cardtype/{cardtype}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatus(@PathVariable String username,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String accountdetails,@PathVariable String expirationmonth,@PathVariable String expirationyear,@PathVariable String cvvnumber,@PathVariable String cardtype) {
		 Boolean result_notify = mypaymentaccountsdaoimpl.addcreditcardaccount(username,firstname,lastname,accountdetails,expirationmonth,expirationyear,cvvnumber,cardtype);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
	/***********add checkings account details*****/
	@RequestMapping(value = "/addcheckingsaccount/username/{username}/firstname/{firstname}/lastname/{lastname}/accountdetails/{accountdetails}/routingnumber/{routingnumber}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatuschk(@PathVariable String username,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String accountdetails,@PathVariable String routingnumber) {
		 Boolean result_notify = mypaymentaccountsdaoimpl.addcheckingsaccount(username,firstname,lastname,accountdetails,routingnumber);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
	
	/***********add savings account details*****/
	@RequestMapping(value = "/addsavingsaccount/username/{username}/firstname/{firstname}/lastname/{lastname}/accountdetails/{accountdetails}/routingnumber/{routingnumber}", method = RequestMethod.GET)
 
	 public @ResponseBody
	 Status getStatus(@PathVariable String username,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String accountdetails,@PathVariable String routingnumber) {
		 Boolean result_notify = mypaymentaccountsdaoimpl.addsavingsaccount(username,firstname,lastname,accountdetails,routingnumber);
		 Status validity = statuscontrollerobj.isValid(result_notify);
		 return validity;	
	}
}
