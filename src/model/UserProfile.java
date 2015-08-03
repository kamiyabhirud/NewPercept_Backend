package model;

public class UserProfile {
	
	public String username;
	public String firstname;
	public String lastname;
	public String email;
	public String phonenumber;
	public String preferredcontact;
	public String mailingaddress;
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPreferredcontact() {
		return preferredcontact;
	}

	public void setPreferredcontact(String preferredcontact) {
		this.preferredcontact = preferredcontact;
	}

	public String getMailingaddress() {
		return mailingaddress;
	}

	public void setMailingaddress(String mailingaddress) {
		this.mailingaddress = mailingaddress;
	}

		//constructor
		public UserProfile(String username,
		 String firstname,
		 String lastname,
	     String email,
	     String phonenumber,
		 String preferredcontact,
		 String mailingaddress) {
			super();
			this.username = username;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.phonenumber = phonenumber;
			this.preferredcontact = preferredcontact;
			this.mailingaddress = mailingaddress;
		}
		
		public UserProfile() {
			// TODO Auto-generated constructor stub
		}
		
		
}
