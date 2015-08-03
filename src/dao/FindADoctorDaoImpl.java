package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.FindADoctor;
import model.ProductsAtDoctors;
import model.ServicesAtDoctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FindADoctorDaoImpl implements FindADoctorDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	@Override
	public List<FindADoctor> searchByDoctorName(String docfirstname , String doclastname , String state) {
		String query = "select doctorfirstname, doctorlastname, officename, workinghours, workingdays, streetaddress, state, city, zipcode, doctorcontact "
				+ "from doctorinfo where doctorfirstname = '"
				+  docfirstname +"' and doctorlastname = '"+doclastname+"' and state = '"+state+"'";

		List<FindADoctor> findadoclist = new ArrayList<FindADoctor>();

		List<Map<String, Object>> findbydocnamerow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> doctorrow : findbydocnamerow) {
			FindADoctor newdoctorrow = new FindADoctor();

			newdoctorrow.setDocfirstname(String.valueOf(doctorrow.get("doctorfirstname")));
			newdoctorrow.setDoclastname(String.valueOf(doctorrow.get("doctorlastname")));
			newdoctorrow.setOfficename(String.valueOf(doctorrow.get("officename")));
			newdoctorrow.setWorkinghours(String.valueOf(doctorrow.get("workinghours")));
			newdoctorrow.setWorkingdays(String.valueOf(doctorrow.get("workingdays")));
			newdoctorrow.setStreetaddress(String.valueOf(doctorrow.get("streetaddress")));
			newdoctorrow.setState(String.valueOf(doctorrow.get("state")));
			newdoctorrow.setCity(String.valueOf(doctorrow.get("city")));
			newdoctorrow.setZipcode(String.valueOf(doctorrow.get("zipcode")));
			newdoctorrow.setDoctorcontact(String.valueOf(doctorrow.get("doctorcontact")));
			findadoclist.add(newdoctorrow);
		}

		return findadoclist;
	}

	@Override
	public List<FindADoctor> searchByOfficeName(String officename , String city, String state){
	
		String query = "select doctorfirstname, doctorlastname, officename, workinghours, workingdays, streetaddress, state, city, zipcode, doctorcontact "
				+ "from doctorinfo where officename = '"+officename+"' and city = '"+city+"' and state = '"+state+"'";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<FindADoctor> findadoclist = new ArrayList<FindADoctor>();

		List<Map<String, Object>> findbydocnamerow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> doctorrow : findbydocnamerow) {
			FindADoctor newdoctorrow = new FindADoctor();

			newdoctorrow.setDocfirstname(String.valueOf(doctorrow.get("doctorfirstname")));
			newdoctorrow.setDoclastname(String.valueOf(doctorrow.get("doctorlastname")));
			newdoctorrow.setOfficename(String.valueOf(doctorrow.get("officename")));
			newdoctorrow.setWorkinghours(String.valueOf(doctorrow.get("workinghours")));
			newdoctorrow.setWorkingdays(String.valueOf(doctorrow.get("workingdays")));
			newdoctorrow.setStreetaddress(String.valueOf(doctorrow.get("streetaddress")));
			newdoctorrow.setState(String.valueOf(doctorrow.get("state")));
			newdoctorrow.setCity(String.valueOf(doctorrow.get("city")));
			newdoctorrow.setZipcode(String.valueOf(doctorrow.get("zipcode")));
			newdoctorrow.setDoctorcontact(String.valueOf(doctorrow.get("doctorcontact")));
			findadoclist.add(newdoctorrow);
		}
		return findadoclist;

	}	
/*************** find doctor by location**********/
	
	@Override
	public List<FindADoctor> searchByLocation(String zipcode, String state, String brand,String eyeexam,
			String extendedhrs,String visiontherapy,String smallchild,String advance,String expresseyewear,String laservision,
			String bigchild,String preventativeeyecare,String specialoffer,String glasses,
			String featuredframe,String contacts,String sportseye,String unitylens,String hardtfit,String otispiper,String safetypro,String lowvision,String googleglass){
	
		String query = "select distinct doctorfirstname, doctorlastname, officename, workinghours, workingdays, streetaddress, state, city, zipcode, doctorcontact "
				+ "from doctorinfo d , doctorservices s, doctorproduct p, doctorbrand b "
				+ "where d.pkdoctorinfo=s.fkdoctor and d.pkdoctorinfo=p.fkdoctor and d.pkdoctorinfo=b.fkdoctor and "
				+ "d.zipcode = '"+zipcode+"' and d.state = '"+state+"' and  b.brandname = '"+brand+"' and "
				+ " s.fkservicename in('"+eyeexam +"','"+ extendedhrs+"','"+ visiontherapy+"','"+smallchild+"','"+ advance+"','"+ expresseyewear+"','"+ laservision+"','"+ bigchild
				+"','"+preventativeeyecare+"','"+ specialoffer+"')  and "
			    + " p.fkproduct in('"+glasses+"','"+ featuredframe+"','"+contacts+"','"+ sportseye+"','"+ unitylens+"','"+hardtfit+"','"+otispiper+"','"+safetypro+"','"
			    + lowvision +"','"+ googleglass+"')";
		
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<FindADoctor> findadoclist = new ArrayList<FindADoctor>();

		List<Map<String, Object>> findbydocnamerow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> doctorrow : findbydocnamerow) {
			FindADoctor newdoctorrow = new FindADoctor();

			newdoctorrow.setDocfirstname(String.valueOf(doctorrow.get("doctorfirstname")));
			newdoctorrow.setDoclastname(String.valueOf(doctorrow.get("doctorlastname")));
			newdoctorrow.setOfficename(String.valueOf(doctorrow.get("officename")));
			newdoctorrow.setWorkinghours(String.valueOf(doctorrow.get("workinghours")));
			newdoctorrow.setWorkingdays(String.valueOf(doctorrow.get("workingdays")));
			newdoctorrow.setStreetaddress(String.valueOf(doctorrow.get("streetaddress")));
			newdoctorrow.setState(String.valueOf(doctorrow.get("state")));
			newdoctorrow.setCity(String.valueOf(doctorrow.get("city")));
			newdoctorrow.setZipcode(String.valueOf(doctorrow.get("zipcode")));
			newdoctorrow.setDoctorcontact(String.valueOf(doctorrow.get("doctorcontact")));
			findadoclist.add(newdoctorrow);
		}
		return findadoclist;

	}
	
	/****** get services ********/
	
	
	@Override
	public List<ServicesAtDoctors> getservices(String docfirstname){
	
		String query = "select distinct fkservicename from doctorservices where docfirstname = '"+docfirstname+"'";
		
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<ServicesAtDoctors> serviceslist = new ArrayList<ServicesAtDoctors>();

		List<Map<String, Object>> servicesrow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> doctorrow : servicesrow) {
			ServicesAtDoctors newservices = new ServicesAtDoctors();

			newservices.setServices(String.valueOf(doctorrow.get("fkservicename")));
			
			serviceslist.add(newservices);
		}
		return serviceslist;

	}
	
/****** get products ********/
	
	
	@Override
	public List<ProductsAtDoctors> getproducts(String docfirstname){
	
		String query = "select distinct fkproduct from doctorproduct where docfirstname = '"+docfirstname+"'";
		
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<ProductsAtDoctors> productslist = new ArrayList<ProductsAtDoctors>();

		List<Map<String, Object>> productsrow = jdbcTemplate.queryForList(query);

		for (Map<String, Object> doctorrow : productsrow) {
			ProductsAtDoctors newproducts = new ProductsAtDoctors();

			newproducts.setProducts(String.valueOf(doctorrow.get("fkproduct")));
			
			productslist.add(newproducts);
		}
		return productslist;

	}
	
}
