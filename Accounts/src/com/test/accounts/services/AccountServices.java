package com.test.accounts.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.test.accounts.db.Db;
import com.test.accounts.models.Statement;

public class AccountServices {
	static Logger log = Logger.getLogger(AccountServices.class.getName());
	public static final String ERR1_CON_CLOSE ="Error closing connection";
	public static final String ERR2_CONN ="Error getting data";
	public static final String FETCH_DATA ="Fetching statements from DB";
	public static final String FETCH1_DATA ="Successfully fetched : ";
	public static final String DATEFORMAT ="dd/MM/yyyy";
	public static final String ID="id : ";
	
	public static final String SALT = "mysalttext";
///fetch dates
public Date  ConvertStringtoDate(String date) {  
	Date date1 = null;
	try {
		date1 = new SimpleDateFormat(DATEFORMAT).parse(date);
	} catch (ParseException e) {
		
		e.printStackTrace();
	}  
    
  
    return date1;  
}  

public static String generateHash(String input) {
	String saltedpassword = input + SALT;
	StringBuilder hash = new StringBuilder();

	try {
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		byte[] hashedBytes = sha.digest(saltedpassword.getBytes());
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < hashedBytes.length;idx++) {
			byte b = hashedBytes[idx];
			hash.append(digits[(b & 0xf0) >> 4]);
			hash.append(digits[b & 0x0f]);
		}
	} catch (NoSuchAlgorithmException e) {
		// handle error here.
	}

	return hash.toString();
}



public String ConvertDatetoString(Date date)
{
	DateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);  
	return dateFormat.format(date);
	
}

public String getAccounNumberForGivenAccountID( int account_id) {
	String result = null;
	
	Connection con = null;
	PreparedStatement stmt=null;
	try {
		log.info(FETCH_DATA);	
		con = Db.getConnection();
	 stmt = con.prepareStatement("SELECT account_number FROM account WHERE ID = ?");
	stmt.setInt(1, account_id);
		ResultSet rs = stmt.executeQuery();		
		while (rs.next())
		{
			log.debug(ID+rs.getString(1));
			result = generateHash(result);
			
		}
			
		
		log.info(FETCH1_DATA + result);
        stmt.close();
		con.close();
		return result;
	} catch (Exception e) {
		log.debug(ERR2_CONN);
		e.printStackTrace();
	} finally {
		try {
			if (stmt!=null)
			  {
			   stmt.close();
			   }
			if (con!=null)
			  {
			   con.close();
			   }
		} catch (Exception e) {
			log.info(ERR1_CON_CLOSE);
		}
	}
	return result;
}


public List<Statement> getStatementsOfDateRange(String fromDate,String toDate, int account_id) {
	List<Statement> list = new LinkedList<>();
	
	Connection con = null;
	PreparedStatement stmt=null;
	try {
		log.info(FETCH_DATA);
		log.debug("fromdate : " +ConvertStringtoDate(fromDate));		
		log.debug("fromdate : " +ConvertStringtoDate(toDate));
		
		con = Db.getConnection();
		log.debug("convertFromdate :"+(ConvertStringtoDate(fromDate)));
		log.debug("convertTodate :"+(ConvertStringtoDate(toDate)));
	 stmt = con.prepareStatement("SELECT account_id,DateValue(Replace(datefield,'.','/')),ID,amount FROM statement WHERE account_id = ? AND DateValue(Replace(datefield,'.','/')) BETWEEN  ?  AND  ?;");
	stmt.setInt(1, account_id);
	stmt.setDate(2, new java.sql.Date((ConvertStringtoDate(fromDate)).getTime()));
	stmt.setDate(3, new java.sql.Date((ConvertStringtoDate(toDate)).getTime()));
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next())
		{
			log.debug(ID+rs.getInt(3));
			list.add(new Statement(rs.getInt(1),rs.getDate(2),rs.getInt(3), rs.getString(4)));
		}
			
		
		log.info(FETCH1_DATA + list.toString());
        stmt.close();
		con.close();
		return list;
	} catch (Exception e) {
		log.debug(ERR2_CONN);
		e.printStackTrace();
	} finally {
		try {
			if (stmt!=null)
			  {
			   stmt.close();
			   }
			if (con!=null)
			  {
			   con.close();
			   }
		} catch (Exception e) {
			log.info(ERR1_CON_CLOSE);
		}
	}
	return list;
}


public List<Statement> getStatementsOfAmountRange(String fromAmount,String toAmount, int account_id) {
	List<Statement> list = new LinkedList<>();
	
	Connection con = null;
	PreparedStatement stmt =null;
	try {
		log.info(FETCH_DATA);
		int i = Integer.parseInt(fromAmount);
		int j = Integer.parseInt(toAmount);
		log.debug("fromAmount: " +fromAmount);		
		log.debug("fromAmount : " +toAmount);
		
		con = Db.getConnection();
	 stmt = con.prepareStatement("SELECT account_id,DateValue(Replace(datefield,'.','/')),ID,amount FROM statement WHERE account_id = ? AND CAST(amount AS INT) BETWEEN  ?  AND  ?;");
	stmt.setInt(1, account_id);
	stmt.setInt(2, i);
	stmt.setInt(3, j);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next())
		{
			log.debug((ID+rs.getInt(3)));
			list.add(new Statement(rs.getInt(1),rs.getDate(2),rs.getInt(3), rs.getString(4)));
		}
			
		
		log.debug(FETCH1_DATA + list.toString());
         stmt.close();
		con.close();
		return list;
	} catch (Exception e) {
		log.debug(ERR2_CONN);
		e.printStackTrace();
	} finally {
		try {
			if (stmt!=null)
			  {
			   stmt.close();
			   }
			if (con!=null)
			  {
			   con.close();
			   }
		} catch (Exception e) {
			log.debug(ERR1_CON_CLOSE);
		}
	}
	return list;
}


public Date getTodaysDate()
{
	SimpleDateFormat formatter = new SimpleDateFormat(DATEFORMAT);  
    Date date = new Date();  
    return ConvertStringtoDate(formatter.format(date));  
}


public Date  getThreeMonthsBackDate(Date date)
{
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);         
	cal.add(Calendar.MONTH, -3);
	SimpleDateFormat format1 = new SimpleDateFormat(DATEFORMAT);          
	String inActiveDate = null;
	inActiveDate = format1.format(cal.getTime());
	log.debug("inActiveDate" +inActiveDate);
	return ConvertStringtoDate(inActiveDate);
}
public List<Statement> getStatementsForUser( int account_id) {
	List<Statement> list = new LinkedList<>();
	
	Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement stmt1 = null;
	try {
		log.info(FETCH_DATA);
		log.debug("accoubt_id: " +account_id);	
		con = Db.getConnection();
		
		stmt = con.prepareStatement("SELECT MAX(DateValue(Replace(datefield,'.','/'))) AS maxvalue FROM statement WHERE account_id = ?");
		stmt.setInt(1, account_id);	
		ResultSet rs = stmt.executeQuery();
		
		String tempDate=null;
		Date dateFromResultSet=null;
		while (rs.next())
		{
			
			 dateFromResultSet=rs.getDate(1);
			
			 tempDate=ConvertDatetoString(dateFromResultSet);
			 log.debug("Latest Date : "+ConvertStringtoDate(tempDate));
			 log.debug("Three months back date : "+getThreeMonthsBackDate(dateFromResultSet));
		}
		stmt.close();
		Date date2 =getThreeMonthsBackDate(dateFromResultSet);
		String threemonthsback= ConvertDatetoString(date2);
		 stmt1 = con.prepareStatement("SELECT account_id,DateValue(Replace(datefield,'.','/')),ID,amount FROM statement WHERE account_id = ? AND DateValue(Replace(datefield,'.','/')) BETWEEN  ?  AND  ?;");	
		stmt1.setInt(1, account_id);
		stmt1.setDate(2, new java.sql.Date((ConvertStringtoDate(threemonthsback)).getTime()));
		stmt1.setDate(3, new java.sql.Date((ConvertStringtoDate(tempDate)).getTime()));
		
ResultSet rs1 = stmt1.executeQuery();
		
		while (rs1.next())
		{
			log.debug(ID+rs1.getInt(3));
			list.add(new Statement(rs1.getInt(1),rs1.getDate(2),rs1.getInt(3), rs1.getString(4)));
		}
			
		log.info(FETCH1_DATA + list.toString());
		stmt1.close();
		con.close();
		return list;
	} catch (Exception e) {
		log.debug(ERR2_CONN);
		e.printStackTrace();
	} finally {
		try {
			if (stmt1!=null)
			  {
			   stmt1.close();
			   
			   }
			if (stmt!=null)
			  {
			   stmt.close();
			   
			   }
			if (con!=null)
			  {
			   con.close();
			   
			   }
		} catch (Exception e) {
			log.debug(ERR1_CON_CLOSE);
		}
	}
	return list;
}



}
