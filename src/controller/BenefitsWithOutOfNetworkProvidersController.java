package controller;

import model.BenefitsWithOutOfNetworkProviders;
import model.MemberVisionCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.BenefitsWithOutOfNetworkProvidersDaoImpl;

@RestController
@RequestMapping("/service/benefitswithoutofnetworkproviders")
public class BenefitsWithOutOfNetworkProvidersController {

	@Autowired
	private BenefitsWithOutOfNetworkProvidersDaoImpl benefitswithoutofnetworkprovidersdaoimpl;

	/*** Find-A-Doctor by Doctor Name     ****/
	@RequestMapping(value = "/getbenefitswithoutofnetwork/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	BenefitsWithOutOfNetworkProviders searchbydoctorgetdoctordetails(@PathVariable String username) {
		BenefitsWithOutOfNetworkProviders result_benefitsoutofnetwork = benefitswithoutofnetworkprovidersdaoimpl.getoutofnetworkbenefits(username);
		return result_benefitsoutofnetwork;
	}
	
}
