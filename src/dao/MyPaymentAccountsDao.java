package dao;

import model.MyPaymentAccounts;

public interface MyPaymentAccountsDao {
	
	public Boolean deleteaccount(String acctnumber);
	
	public Boolean editaccount(String acctnumber, String expirationmonth, String expirationyear);
	
	public Boolean addcreditcardaccount(String username, String firstname, String lastname, String creditcardnumber,String expitymonth,String expiryyear,String cvv, String cardtype);

	public Boolean addcheckingsaccount(String username, String firstname, String lastname, String checkingsacctnumber,String routingnumber);
	
	public Boolean addsavingsaccount(String username, String firstname, String lastname,String checkingsacctnumber,String routingnumber);
}
