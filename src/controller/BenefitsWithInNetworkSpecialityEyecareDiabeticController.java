package controller;

import model.BenefitsWithInNetworkSpecialityEyecareDiabetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.BenefitsWithInNetworkSpecialityEyecareDiabeticDaoImpl;

@RestController
@RequestMapping("/service/benefitswithinnetwork")
public class BenefitsWithInNetworkSpecialityEyecareDiabeticController {

	@Autowired
	private BenefitsWithInNetworkSpecialityEyecareDiabeticDaoImpl benefitswithinnetworkspecialityeyecarediabeticdaoimpl;

	/*** Benefits in network speciality care diabetic     ****/
	@RequestMapping(value = "/getbenefitswithinnetwork/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	BenefitsWithInNetworkSpecialityEyecareDiabetic getbenefitsinnetworkspecialityeyecare(@PathVariable String username) {
		BenefitsWithInNetworkSpecialityEyecareDiabetic result_benefitsinnetworkspeciality = benefitswithinnetworkspecialityeyecarediabeticdaoimpl.getinnetworkbenefits(username);
		return result_benefitsinnetworkspeciality;
	}
	
}
