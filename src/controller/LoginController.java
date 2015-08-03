package controller;

import model.Login;
import model.Status;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;

import dao.LoginDao;

@RestController
@RequestMapping("/service/logincredentials")
public class LoginController {

	@Autowired
	private LoginDao loginDao;
	private StatusController statuscontrollerobj = new StatusController();

	@RequestMapping(value = "/username/{username}/password/{password}", method = RequestMethod.GET)
	public @ResponseBody
	Status getCredentials(@PathVariable String username,@PathVariable String password) {
	 Boolean result = loginDao.isAuthorized(username,password);
	 System.out.println("result------->>>>>>>>>>>>>>>"+result);
	 Status validity = statuscontrollerobj.isValid(result);
	 return validity;	
	}
	
	
}
