package model;

public class MemberVisionCard {

	public String username;
	public String coveragetype;
	public String doctornetwork;
	public String copayexam;
	public String copaymaterials;
	
	
	public MemberVisionCard(String username, String coveragetype,
			String doctornetwork, String copayexam, String copaymaterials) {
		super();
		this.username = username;
		this.coveragetype = coveragetype;
		this.doctornetwork = doctornetwork;
		this.copayexam = copayexam;
		this.copaymaterials = copaymaterials;
	}
	
	
	public MemberVisionCard() {
		super();
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCoveragetype() {
		return coveragetype;
	}
	public void setCoveragetype(String coveragetype) {
		this.coveragetype = coveragetype;
	}
	public String getDoctornetwork() {
		return doctornetwork;
	}
	public void setDoctornetwork(String doctornetwork) {
		this.doctornetwork = doctornetwork;
	}
	public String getCopayexam() {
		return copayexam;
	}
	public void setCopayexam(String copayexam) {
		this.copayexam = copayexam;
	}
	public String getCopaymaterials() {
		return copaymaterials;
	}
	public void setCopaymaterials(String copaymaterials) {
		this.copaymaterials = copaymaterials;
	}
	
	
}
