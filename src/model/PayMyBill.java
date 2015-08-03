package model;

public class PayMyBill {

	public String remainingbalance;
	public String amountdue;
	public String pastdueamount;
	public String accountdetails;
	
	public PayMyBill() {
		super();
	}
	public PayMyBill(String remainingbalance, String amountdue,
			String pastdueamount, String accountdetails) {
		super();
		this.remainingbalance = remainingbalance;
		this.amountdue = amountdue;
		this.pastdueamount = pastdueamount;
		this.accountdetails = accountdetails;
	}
	public String getRemainingbalance() {
		return remainingbalance;
	}
	public void setRemainingbalance(String remainingbalance) {
		this.remainingbalance = remainingbalance;
	}
	public String getAmountdue() {
		return amountdue;
	}
	public void setAmountdue(String amountdue) {
		this.amountdue = amountdue;
	}
	public String getPastdueamount() {
		return pastdueamount;
	}
	public void setPastdueamount(String pastdueamount) {
		this.pastdueamount = pastdueamount;
	}
	public String getAccountdetails() {
		return accountdetails;
	}
	public void setAccountdetails(String accountdetails) {
		this.accountdetails = accountdetails;
	}
	
}
