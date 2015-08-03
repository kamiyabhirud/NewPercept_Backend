package controller;

import java.util.List;

import model.FindADoctor;
import model.ProductsAtDoctors;
import model.ServicesAtDoctors;
import dao.FindADoctorDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service/findadoctorsearch")
public class FindADoctorController {

	@Autowired
	private FindADoctorDaoImpl findadoctordaoimpl;

	/*** Find-A-Doctor by Doctor Name     ****/
	@RequestMapping(value = "/searchbydoctorname/doctorfirstname/{doctorfirstname}/doctorlastname/{doctorlastname}/state/{state}", method = RequestMethod.GET)
	
	public @ResponseBody
	List<FindADoctor> searchbydoctorgetdoctordetails(@PathVariable String doctorfirstname, @PathVariable String doctorlastname,  @PathVariable String state) {
		// User newuser = new User();

		List<FindADoctor> result_doctordetails = findadoctordaoimpl.searchByDoctorName(doctorfirstname,doctorlastname,state);
		return result_doctordetails;
	}
	
	/*** Find-A-Doctor by Office Name***/
	@RequestMapping(value = "/searchbyofficename/officename/{officename}/city/{city}/state/{state}", method = RequestMethod.GET)

	public @ResponseBody
	List<FindADoctor> searchbyofficegetdoctordetails(@PathVariable String officename, @PathVariable String city,  @PathVariable String state) {
		List<FindADoctor> result_doctordetails = findadoctordaoimpl.searchByOfficeName(officename,city,state);
		return result_doctordetails;
	}
	
	/*** Find-A-Doctor by Location****/
	
	@RequestMapping(value = "/searchbylocation/zipcode/{zipcode}/state/{state}/brand/{brand}/eyeexam/{eyeexam}/"
			+ "extendedhrs/{extendedhrs}/visiontherapy/{visiontherapy}/smallchild/{smallchild}/advance/{advance}/expresseyewear/{expresseyewear}/"
			+ "laservision/{laservision}/bigchild/{bigchild}/preventativeeyecare/{preventativeeyecare}/specialoffer/{specialoffer}/"
			+ "glasses/{glasses}/featuredframe/{featuredframe}/contacts/{contacts}/sportseye/{sportseye}/unitylens/{unitylens}/"
			+ "hardtfit/{hardtfit}/otispiper/{otispiper}/safetypro/{safetypro}/lowvision/{lowvision}/googleglass/{googleglass}", method = RequestMethod.GET)

	public @ResponseBody
	List<FindADoctor> searchbylocationgetdoctordetails(@PathVariable String zipcode, @PathVariable String state,@PathVariable String brand,@PathVariable String eyeexam,
			 @PathVariable String extendedhrs,  @PathVariable String visiontherapy,  @PathVariable String smallchild,  @PathVariable String advance,  @PathVariable String expresseyewear, @PathVariable String  laservision,
			 @PathVariable String bigchild, @PathVariable String  preventativeeyecare,  @PathVariable String specialoffer,
			@PathVariable String glasses,@PathVariable String featuredframe,@PathVariable String contacts,@PathVariable String sportseye,@PathVariable String unitylens,
			@PathVariable String hardtfit,@PathVariable String  otispiper,@PathVariable String safetypro,@PathVariable String lowvision,@PathVariable String googleglass) {
		
		List<FindADoctor> result_doctordetails = findadoctordaoimpl.searchByLocation(zipcode, state, brand,eyeexam,
				 extendedhrs, visiontherapy, smallchild, advance, expresseyewear, laservision,
				 bigchild, preventativeeyecare, specialoffer,
				glasses, featuredframe,contacts,sportseye,unitylens,hardtfit, otispiper, safetypro, lowvision, googleglass);
		
		return result_doctordetails;
	}
	/*****get services  List<ServicesAtDoctors> getservices(String docfirstname, String doclastname){**********/
	@RequestMapping(value = "/getservicesatdoctors/docfirstname/{docfirstname}", method = RequestMethod.GET)

	public @ResponseBody
	List<ServicesAtDoctors> getallservices(@PathVariable String docfirstname) {
		List<ServicesAtDoctors> result_servicesdetails = findadoctordaoimpl.getservices(docfirstname);
		return result_servicesdetails;
	}
	
	/*****get products  List<ServicesAtDoctors> getservices(String docfirstname, String doclastname){**********/
	@RequestMapping(value = "/getproductsatdoctors/docfirstname/{docfirstname}", method = RequestMethod.GET)

	public @ResponseBody
	List<ProductsAtDoctors> getallproducts(@PathVariable String docfirstname) {
		List<ProductsAtDoctors> result_productssdetails = findadoctordaoimpl.getproducts(docfirstname);
		return result_productssdetails;
	}
	
}
