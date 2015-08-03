package model;

public class AutomaticPayment {
	
	public String autopayaccountnumber;
	public String autopayfrequency;
    public String autopaystartday;
    
    
    
	public AutomaticPayment() {
		super();
	}
	
	public AutomaticPayment(
			String autopayfrequency, String autopaystartday,String autopayaccountnumber) {
		super();
		this.autopayfrequency = autopayfrequency;
		this.autopaystartday = autopaystartday;
		this.autopayaccountnumber = autopayaccountnumber;
	}
	public String getAutopayaccountnumber() {
		return autopayaccountnumber;
	}
	public void setAutopayaccountnumber(String autopayaccountnumber) {
		this.autopayaccountnumber = autopayaccountnumber;
	}
	public String getAutopayfrequency() {
		return autopayfrequency;
	}
	public void setAutopayfrequency(String autopayfrequency) {
		this.autopayfrequency = autopayfrequency;
	}
	public String getAutopaystartday() {
		return autopaystartday;
	}
	public void setAutopaystartday(String autopaystartday) {
		this.autopaystartday = autopaystartday;
	}
	
}
