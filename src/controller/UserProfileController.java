package controller;

import model.Status;
import model.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.LoginDao;
import dao.UserProfileDaoImpl;

@RestController
@RequestMapping("/service/userprofile")
public class UserProfileController {

	@Autowired
	private UserProfileDaoImpl userprofiledaoimpl;

	/*** Get User Profile details     ****/
	@RequestMapping(value = "/getuserprofile/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	UserProfile getusernameprofile(@PathVariable String username) {
		UserProfile result_userprofile = userprofiledaoimpl.getuserprofile(username);
		return result_userprofile;
	}
	
	/************ Update User Preferred contact ****/
	
	private StatusController statuscontrollerobj = new StatusController();
	
//	@RequestMapping(value = "/updatepreferredcontact/preferredcontact/{preferredcontact}/email/{email}/phonenumber/{phonenumber}/username/{username}", method = RequestMethod.GET)
//	public @ResponseBody
//	int updateuserpreferredcontact(@PathVariable String preferredcontact,@PathVariable String email,@PathVariable String phonenumber,@PathVariable String username) {
//	 int result = userprofiledaoimpl.updatepreferredcontact(preferredcontact,email,phonenumber,username);
//	 System.out.println("result------->>>>>>>>>>>>>>>"+result);
////	 Status validity = statuscontrollerobj.isValid(result);
//	 return result;	
//	}
	
	/******/
	@RequestMapping(value = "/updatepreferredcontact/username/{username}/firstname/{firstname}/lastname/{lastname}/email/{email}/phonenumber/{phonenumber}/preferredcontact/{preferredcontact}/mailingaddress/{mailingaddress}", method = RequestMethod.GET)
	public @ResponseBody
	Status updateuserpreferredcontact(@PathVariable String username,@PathVariable String firstname,
			@PathVariable String lastname, @PathVariable String email,@PathVariable String phonenumber,
			@PathVariable String preferredcontact, @PathVariable String mailingaddress) {
		UserProfile userprofileobj = new UserProfile(username, firstname, lastname, email,phonenumber, preferredcontact, mailingaddress);

		Boolean result_updateuser = userprofiledaoimpl.updatepreferredcontact(userprofileobj);
		Status validity = statuscontrollerobj.isValid(result_updateuser);
		 return validity;

	}
	
}

