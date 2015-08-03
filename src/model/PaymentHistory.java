package model;

public class PaymentHistory {
	
	public String username;
	public String customernumber;
	public String pastdueamount;
	public String amountdue;
	public String remainingbalance;
	public String date;
	public String doctortype;
	public String transactionnumber;
	public String credit;
	public String debit;
	public String name;
	public String description;
	
	
	public PaymentHistory(String username, String customernumber,
			String pastdueamount, String amountdue, String remainingbalance,
			String date, String doctortype, String transactionnumber,
			String credit, String debit, String name, String description) {
		super();
		this.username = username;
		this.customernumber = customernumber;
		this.pastdueamount = pastdueamount;
		this.amountdue = amountdue;
		this.remainingbalance = remainingbalance;
		this.date = date;
		this.doctortype = doctortype;
		this.transactionnumber = transactionnumber;
		this.credit = credit;
		this.debit = debit;
		this.name = name;
		this.description = description;
	}
	
	
	public PaymentHistory() {
		super();
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	public String getPastdueamount() {
		return pastdueamount;
	}
	public void setPastdueamount(String pastdueamount) {
		this.pastdueamount = pastdueamount;
	}
	public String getAmountdue() {
		return amountdue;
	}
	public void setAmountdue(String amountdue) {
		this.amountdue = amountdue;
	}
	public String getRemainingbalance() {
		return remainingbalance;
	}
	public void setRemainingbalance(String remainingbalance) {
		this.remainingbalance = remainingbalance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDoctortype() {
		return doctortype;
	}
	public void setDoctortype(String doctortype) {
		this.doctortype = doctortype;
	}
	public String getTransactionnumber() {
		return transactionnumber;
	}
	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
