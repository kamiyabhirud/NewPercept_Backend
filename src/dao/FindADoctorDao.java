package dao;

import java.util.List;

import model.FindADoctor;
import model.ProductsAtDoctors;
import model.ServicesAtDoctors;

public interface FindADoctorDao {
	
	public  List<FindADoctor> searchByDoctorName(String docfirstname, String doclastname,  String state);
	
//	public FindADoctor searchByOfficeName(String officename, String city, String state);
	
	public List<FindADoctor> searchByOfficeName(String officename, String city, String state);
	
//	public FindADoctor searchByLocation();
	
//	public List<FindADoctor> searchByLocation(String zipcode, String state, String brand,String eyeexam,String extendedhrs,String visiontherapy,String smallchild,String advance,String expresseyewear,String laservision,
//			String bigchild,String preventativeeyecare,String specialoffer,
//	String glasses,String featuredframe,String contacts,String sportseye,String unitylens,String hardtfit,String otispiper,String safetypro,String lowvision,String googleglass);

	public List<FindADoctor> searchByLocation(String zipcode, String state, String brand,String eyeexam,
			String extendedhrs,String visiontherapy,String smallchild,String advance,String expresseyewear,String laservision,
			String bigchild,String preventativeeyecare,String specialoffer,
			String glasses,String featuredframe,String contacts,String sportseye,String unitylens,String hardtfit,String otispiper,String safetypro,String lowvision,String googleglass);

	public List<ServicesAtDoctors> getservices(String docfirstname);
	
	public List<ProductsAtDoctors> getproducts(String docfirstname);
}
