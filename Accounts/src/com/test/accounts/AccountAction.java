package com.test.accounts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.test.accounts.models.Statement;
import com.test.accounts.services.AccountServices;

public class AccountAction extends ActionSupport implements SessionAware{
	static Logger loghelper = Logger.getLogger(AccountAction.class.getName());

	public static final String SUCCESS="success";
	
	private transient List<Statement> statementList;
	private  transient List<Statement> amountStatementList;
	private transient List<Statement> threeMonthsStatementList;
	private String  fromDate;
	private String toDate;
	private String accountID;
	private transient AccountServices accountServices;
	private boolean error;
	private String accountNumber;
	private String errorMessage = "";
	
	
	private Date datefield;
	private String amount;
	private int account_id;
	private int ID;
	
	private String fromAmount;
	private String toAmount;
	
	public boolean type=false;
	public boolean type1=false;
	public boolean type3=false;
	SessionMap<String,String> sessionmap;  
	
	
	
public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}


public boolean isType3() {
		return type3;
	}


	public void setType3(boolean type3) {
		this.type3 = type3;
	}


public Date CustomDate(Date date) {
        
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(date);  
    java.util.Date dateTemp = null;
	try {
		dateTemp = formatter.parse(strDate);
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	loghelper.debug("inside customdate : "+dateTemp);
    return dateTemp; 
        
    }
	
	
	public List<Statement> getThreeMonthsStatementList() {
	return threeMonthsStatementList;
}


public boolean isType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public boolean isType1() {
		return type1;
	}


	public void setType1(boolean type1) {
		this.type1 = type1;
	}


public void setThreeMonthsStatementList(List<Statement> threeMonthsStatementList) {
	this.threeMonthsStatementList = threeMonthsStatementList;
}


	public String getFromAmount() {
	return fromAmount;
}


public void setFromAmount(String fromAmount) {
	this.fromAmount = fromAmount;
}


public String getToAmount() {
	return toAmount;
}


public void setToAmount(String toAmount) {
	this.toAmount = toAmount;
}


	public List<Statement> getAmountStatementList() {
	return amountStatementList;
}


public void setAmountStatementList(List<Statement> amountStatementList) {
	this.amountStatementList = amountStatementList;
}


	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
	    this.toDate = toDate;
	}
	public Date getDatefield() {
		return datefield;
	}
	public void setDatefield(Date datefield) {
		this.datefield = datefield;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public AccountServices getAccountServices() {
		return accountServices;
	}
	public void setAccountServices(AccountServices accountServices) {
		this.accountServices = accountServices;
	}
	public List<Statement> getStatementList() {
		return statementList;
	}
	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate =fromDate;
	}
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	
	public AccountAction() {
		
		this.accountServices = new AccountServices();
	}
	
	
	
	public String userpage(){
		loghelper.debug("userpage called : " + sessionmap.toString());  
		this.setError(false);
		if (sessionmap.get(CONSTANTS.ERR) != null) {
			this.setError(true);
			this.setErrorMessage(this.sessionmap.get(CONSTANTS.ERR));
			this.sessionmap.remove(CONSTANTS.ERR);
				}
	    return SUCCESS;  
	}
	
	public String admindatepage(){
		loghelper.debug("admindatepage called : " + sessionmap.toString());  
		this.setError(false);
		if (sessionmap.get(CONSTANTS.ERR) != null) {
			this.setError(true);
			this.setErrorMessage(this.sessionmap.get(CONSTANTS.ERR));
			this.sessionmap.remove(CONSTANTS.ERR);
				}
	    return SUCCESS;  
	}
	
	public String adminamountpage(){
		loghelper.debug("adminamountpage called : " + sessionmap.toString());  
		this.setError(false);
		if (sessionmap.get(CONSTANTS.ERR) != null) {
			this.setError(true);
			this.setErrorMessage(this.sessionmap.get(CONSTANTS.ERR));
			this.sessionmap.remove(CONSTANTS.ERR);
				}
	    return SUCCESS;  
	}
	
	public String getStatementViaDate()
	{
		this.setType(true);
		if(!checkAccountPresentinAccounts())
		{
			loghelper.debug(CONSTANTS.ERR_1);
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_2);
			return CONSTANTS.FAILED;
			
			
		}
		if(((fromDate==null)&&(toDate==null))||((("").equals(fromDate))&&(toDate.equals(""))))
		  {
			this.setStatementList(this.accountServices.getStatementsForUser(account_id));
			return SUCCESS;
		  }
		if((((fromDate==null) || (fromDate.equals("")))&& ((toDate!=null)||(!("").equals(toDate))))||(((toDate==null)||(toDate.equals("")))&&((fromDate!=null)||(!fromDate.equals("")))))
		{
		
		    
			loghelper.debug(CONSTANTS.ERR_5);
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_5);
			return CONSTANTS.FAILED;
		    }
		
		
		if (!validateInputDateFromUser(fromDate,toDate))
		{
			loghelper.debug("Invalid Date");
			return CONSTANTS.FAILED;
		}
					
		this.setStatementList(this.accountServices.getStatementsOfDateRange(fromDate,toDate,account_id));
		loghelper.info(CONSTANTS.DATA_FETCHED);
		return SUCCESS;
		
	}
	
	public boolean checkAccountPresentinAccounts()
	{
		if (this.accountServices.getAccounNumberForGivenAccountID(account_id)!=null)
		{
			this.setAccountNumber(this.accountServices.getAccounNumberForGivenAccountID(account_id));
			loghelper.debug(accountNumber);
			return true;
		}
		return false;
		
	}
	
	public String getStatementViaAmount()
	{
		
		if(!checkAccountPresentinAccounts())
		{
			loghelper.debug(CONSTANTS.ERR_1);
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_2);
			return CONSTANTS.FAILED;
			
		}
		
		this.setType1(true);
		if((fromAmount==null)||(toAmount==null)||(fromAmount.equals(""))||(toAmount.equals(""))){
			this.setAmountStatementList(this.accountServices.getStatementsForUser(account_id));
			return SUCCESS;
		}
		
		if(!validateAmount(fromAmount,toAmount))
		{
			loghelper.debug(CONSTANTS.ERR_1);
			return CONSTANTS.FAILED;
			
		}
		this.setAmountStatementList(this.accountServices.getStatementsOfAmountRange(fromAmount, toAmount, account_id));
		
		loghelper.info(CONSTANTS.DATA_FETCHED);
		return SUCCESS;
		
	}
	
	public boolean validateInputDateFromUser(String fromDate,String toDate)
	{
		String[] fromfdateFromUI=fromDate.split("/");
		String[] toDateFromUI=toDate.split("/");
		if(fromfdateFromUI.length!=3||toDateFromUI.length!=3)
		{
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_3);
			loghelper.debug(CONSTANTS.ERR_3);
			return false;
		}
		if((fromfdateFromUI[0].length()!=2)||(Integer.parseInt(fromfdateFromUI[0])>31)||(toDateFromUI[0].length()!=2)||(Integer.parseInt(toDateFromUI[0])>31))
		{
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_3);
			loghelper.debug(CONSTANTS.ERR_3);
			return false;
		}
		if((fromfdateFromUI[1].length()!=2)||(Integer.parseInt(fromfdateFromUI[1])>12)||(toDateFromUI[1].length()!=2)||(Integer.parseInt(toDateFromUI[1])>12))
		{
			this.sessionmap.put(CONSTANTS.ERR, "Date should be given in dd/MM/yyy format.Month should not be greater than 12");
			loghelper.debug("Date should be given in dd/MM/yyy format.Month should not be greater than 12");
			return false;
		}
		if((fromfdateFromUI[2].length()!=4)||(toDateFromUI[2].length()!=4))
		{
			this.sessionmap.put(CONSTANTS.ERR, "Date should be given in dd/MM/yyy format.year Should be in yyyy");
			loghelper.debug("Date should be given in dd/MM/yyy format.year Should be in yyyy");
			return false;
		}
		
		if((Integer.parseInt(fromfdateFromUI[2]))>(Integer.parseInt(toDateFromUI[2])))
		{
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_4);
			loghelper.debug(CONSTANTS.ERR_4);
			return false;
		}
		if((Integer.parseInt(fromfdateFromUI[2]))==(Integer.parseInt(toDateFromUI[2]))&&(Integer.parseInt(fromfdateFromUI[1]))>(Integer.parseInt(toDateFromUI[1])))
		{
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_4);
			loghelper.debug(CONSTANTS.ERR_4);
			return false;
		}
		if((Integer.parseInt(fromfdateFromUI[2]))==(Integer.parseInt(toDateFromUI[2]))&&(Integer.parseInt(fromfdateFromUI[1]))==(Integer.parseInt(toDateFromUI[1]))&&(Integer.parseInt(fromfdateFromUI[0]))>(Integer.parseInt(toDateFromUI[0])))
		{
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_4);
			loghelper.debug(CONSTANTS.ERR_4);
			return false;
		}
			
			
		return true;
		
	}
	
	public boolean containOnlyDigits(String amount)
	{
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(amount);
		 return m.matches();
		

	}
	
	public boolean validateAmount(String fromAmount, String toAmount)
	{
		if(!containOnlyDigits(fromAmount)||!containOnlyDigits(toAmount))
		{
			loghelper.debug("Enter Valid amount");
			this.sessionmap.put(CONSTANTS.ERR, "Enter valid amount");
			return false;
		}
		
		if(Integer.parseInt(fromAmount)>Integer.parseInt(toAmount))
		{
			loghelper.debug("Enter Valid amount");
			this.sessionmap.put(CONSTANTS.ERR, "To amount should be greater than from Amount");
			return false;
		}
		return true;
	}
	public String getStatementsForUser()
	{
		if(!checkAccountPresentinAccounts())
		{
			loghelper.debug(CONSTANTS.ERR_1);
			this.sessionmap.put(CONSTANTS.ERR, CONSTANTS.ERR_2);
			return CONSTANTS.FAILED;
			
		}
		
		this.setType3(true);

		this.setThreeMonthsStatementList(this.accountServices.getStatementsForUser(account_id));
		loghelper.info(CONSTANTS.DATA_FETCHED);
		return SUCCESS;
		
	}
	
	
	public void setSession(Map<String, Object> sessionMap) { 
	    sessionmap = (SessionMap) sessionMap;
	}  
	
}
