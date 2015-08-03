package model;

public class FindADoctor {

	private String docfirstname;
	private String doclastname;
	private String officename;
	private String workinghours;
	private String workingdays;
	private String streetaddress;
	private String state;
	private String city;
	private String zipcode;
	private String doctorcontact;
	
	public String getDocfirstname() {
		return docfirstname;
	}
	public void setDocfirstname(String docfirstname) {
		this.docfirstname = docfirstname;
	}
	public String getDoclastname() {
		return doclastname;
	}
	public void setDoclastname(String doclastname) {
		this.doclastname = doclastname;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
	}
	public String getWorkinghours() {
		return workinghours;
	}
	public void setWorkinghours(String workinghours) {
		this.workinghours = workinghours;
	}
	public String getWorkingdays() {
		return workingdays;
	}
	public void setWorkingdays(String workingdays) {
		this.workingdays = workingdays;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getDoctorcontact() {
		return doctorcontact;
	}
	public void setDoctorcontact(String doctorcontact) {
		this.doctorcontact = doctorcontact;
	}
	
	//constructor
	public FindADoctor(String docfirstname,
	 String doclastname,
	 String officename,
     String workinghours,
	 String workingdays,
	 String streetaddress,
	 String state,
	 String city,
	 String zipcode,
	 String doctorcontact) {
		super();
		this.docfirstname = docfirstname;
		this.doclastname = doclastname;
		this.officename = officename;
		this.workinghours = workinghours;
		this.workingdays = workingdays;
		this.streetaddress = streetaddress;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.doctorcontact = doctorcontact;
	}
	
	public FindADoctor() {
		// TODO Auto-generated constructor stub
	}
	
	
}
