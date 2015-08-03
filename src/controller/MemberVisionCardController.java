package controller;

import model.MemberVisionCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.MemberVisionCardDaoImpl;

@RestController
@RequestMapping("/service/membervisioncard")
public class MemberVisionCardController {
	
	@Autowired
	private MemberVisionCardDaoImpl membervisioncarddaoimpl;

	/*** Find-A-Doctor by Doctor Name     ****/
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	
	public @ResponseBody
	MemberVisionCard getmembervisioncarddetails(@PathVariable String username) {
		MemberVisionCard result_mvcdetails = membervisioncarddaoimpl.getmembervisioncard(username);
		return result_mvcdetails;
	}
	

}
