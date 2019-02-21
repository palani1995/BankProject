package com.cluster.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cluster.service.LoginService;
import com.cluster.to.NewUserInfoTO;
import com.cluster.to.NewUserSecurityInfoTO;

@SuppressWarnings("serial")
public class BankProjectServlet extends HttpServlet 
{
	LoginService loginService = null;
	public void init() throws ServletException 
	{
		try
		{
			loginService = new LoginService();
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Please check the driver");
		} 
		catch (SQLException e) 
		{
			System.out.println("Please check for sql query and connection");
		}
	}

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		
		String strPath = req.getServletPath();
		System.out.println(strPath);
		try {
		    if (strPath.equals("/sign.do")) {
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/login.jsp");
				requestDispatcher.forward(req, res);
			}
		    else if (strPath.equals("/new.do"))
		    {
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./html/register1.html");
				requestDispatcher.forward(req, res);
			}
		    else if (strPath.equals("/newuser1.do"))
		    {
		    	
		    	String strFname = req.getParameter("fname");
				String strLname = req.getParameter("lname");
				String strUname = req.getParameter("uname");
				String strPwd = req.getParameter("pwd");
				String strRpwd = req.getParameter("rpwd");
				String strDate = req.getParameter("dob");
				String strAge = req.getParameter("age");
				String strGender=req.getParameter("gender");
		    	
		    	boolean b = loginService.checkUserName(strUname);
		    	if (b)
		    	{
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./jsp/personalfailure3.jsp");
	    			requestDispatcher.forward(req, res);
	    
		     	}
		    	else
		    	{
		    		session.setAttribute("FIRSTNAME",strFname);
		    		session.setAttribute("LASTNAME",strLname);
		    		session.setAttribute("USERNAME",strUname);
		    		session.setAttribute("PASSWORD",strPwd);
		    		session.setAttribute("DOB",strDate);
		    		session.setAttribute("AGE",strAge);
		    		session.setAttribute("GENDER",strGender);  		
		    		
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./html/register2.html");
		    		requestDispatcher.forward(req, res);
		 
		    	}
		    	
		   }
		    else if (strPath.equals("/newuser2.do")) 
		    {

		    	String strAdd = req.getParameter("add");
				String strCity = req.getParameter("city");
				String strState = req.getParameter("state");
				String strPincode = req.getParameter("pincode");
				String strPhone = req.getParameter("ph");
				String strAphone = req.getParameter("aph");
				String strEmail = req.getParameter("email");
			
				session.setAttribute("ADDRESS",strAdd);
	    		session.setAttribute("CITY",strCity);
	    		session.setAttribute("STATE",strState);
	    		session.setAttribute("PINCODE",strPincode);
	    		session.setAttribute("PHONE",strPhone);
	    		session.setAttribute("APHONE",strAphone);
	    		session.setAttribute("EMAIL",strEmail);  		
	    	
		    	
		    	RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./html/register3.html");
				requestDispatcher.forward(req, res);
		    }
		    else if (strPath.equals("/newuser3.do")) 
		    {

		    	String strFteacher = req.getParameter("ans1");
				String strFpet = req.getParameter("ans2");
				String strFschool = req.getParameter("ans3");
				
				session.setAttribute("FAVTEACHER",strFteacher);
	    		session.setAttribute("FAVPET",strFpet);
	    		session.setAttribute("FIRSTSCHOOL",strFschool);
	    		
		    	RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/registerconfirm.jsp");
				requestDispatcher.forward(req, res);
		    }
		    
		    else if (strPath.equals("/newuserregistration.do")) 
		    {
		    	try
		    	{
		    	
		    	String firstName = (String) session.getAttribute("FIRSTNAME");
	    		String lastName = (String) session.getAttribute("LASTNAME");
	    		String userName = (String) session.getAttribute("USERNAME");
	    		String password = (String) session.getAttribute("PASSWORD");
	    	
	    		String date = (String) session.getAttribute("DOB");
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    		Date dob = null;
				dob = sdf.parse(date);
		
	    		String age1 = (String) session.getAttribute("AGE");
	    		int age = Integer.parseInt(age1);
	    		String gender = (String) session.getAttribute("GENDER");  	
	    		String address = (String) session.getAttribute("ADDRESS");
	    		String city = (String) session.getAttribute("CITY");
	    		String state = (String) session.getAttribute("STATE");
	    		String pincode1 = (String) session.getAttribute("PINCODE");
	    		long pincode = Long.parseLong(pincode1);
	    		String phone = (String) session.getAttribute("PHONE");
	    		String aphone = (String) session.getAttribute("APHONE");
	    		String email = (String) session.getAttribute("EMAIL"); 
	    		String favTeacher = (String) session.getAttribute("FAVTEACHER");
	    		String favPet = (String) session.getAttribute("FAVPET");
	    		String firstSchool = (String) session.getAttribute("FIRSTSCHOOL");
		    
	    		NewUserInfoTO userInfoTO = new  NewUserInfoTO();
		    	userInfoTO.setFirstName(firstName);
		    	userInfoTO.setLastName(lastName);
		    	userInfoTO.setUserName(userName);
		    	userInfoTO.setPassword(password);
		    	userInfoTO.setDob(dob);
		    	userInfoTO.setAge(age);
		    	userInfoTO.setPincode(pincode);
		    	userInfoTO.setGender(gender);
		    	userInfoTO.setAddress(address);
		    	userInfoTO.setCity(city);
		    	userInfoTO.setState(state);
		    	userInfoTO.setPhoneNo(phone);
		    	userInfoTO.setAPhoneNo(aphone);
		    	userInfoTO.setEmail(email);
		    	userInfoTO.setAns1(favTeacher);
		    	userInfoTO.setAns2(favPet);
		    	userInfoTO.setAns3(firstSchool);
		    	
		    	NewUserSecurityInfoTO nSecurityInfoTO= loginService.newUserRegister(userInfoTO);
		    	req.setAttribute("ACCNO",nSecurityInfoTO.getAccno());
		    	req.setAttribute("PIN", nSecurityInfoTO.getPin());
		    	req.setAttribute("REMBALANCE",nSecurityInfoTO.getAmount());
		   
		    	if (nSecurityInfoTO == null)
		    	{
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./jsp/registerfailure.jsp");
					requestDispatcher.forward(req, res);
		    	}
		    	else
		    	{
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./jsp/registersuccess.jsp");
					requestDispatcher.forward(req, res);
		    	}
		    	}
		    	catch (ParseException e)
		    	{
		    		System.out.println("Error in conversion");
		    	}
		    }

			else if (strPath.equals("/login.do")) 
			{
				String strName = req.getParameter("nme");
				String strPassword = req.getParameter("pwd");
				
				boolean validUser = loginService.check(strName,strPassword);
				session.setAttribute("USERNAME", strName);
				
				if (validUser) {
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/pin.jsp");
					requestDispatcher.forward(req, res);
				} else {
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/loginfailure.jsp");
					requestDispatcher.forward(req, res);
				}

			}
			else if (strPath.equals("/loginhome.do"))
			{
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/login.jsp");
				requestDispatcher.forward(req, res);

			} 
			else if (strPath.equals("/pin.do")) 
			{
				double amount = 0.0;
				String accno = null;
				String userName= (String) session.getAttribute("USERNAME");
				String strPin = req.getParameter("pin");

				boolean pinVerified = loginService.pinVerify(strPin,userName);
				if (pinVerified)
				{
					accno = loginService.getaccno(userName);
					amount = loginService.getamount(userName);
				
					session.setAttribute("REMBALANCE", amount);
					session.setAttribute("ACCNO", accno);
					
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/success.jsp");
					requestDispatcher.forward(req, res);
				} else {
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/pinfailure.jsp");
					requestDispatcher.forward(req, res);
				}
			}

			else if (strPath.equals("/balance.do")) {
				String strName = (String) session.getAttribute("USERNAME");
		
				double availableBalance = loginService.balanceInfo(strName);
				session.setAttribute("REMBALANCE", availableBalance);

				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/balanceenquiry.jsp");
				requestDispatcher.forward(req, res);
			}
			
			else if (strPath.equals("/deposit.do"))
			{
				String strAccount = req.getParameter("acc");
				String strAmount = req.getParameter("amt");

				double dAmount = Double.parseDouble(strAmount);
				double AVamount = loginService.depositAmount(dAmount,strAccount);
				session.setAttribute("REMBALANCE", AVamount);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("./jsp/depositsuccess.jsp");
				requestDispatcher.forward(req, res);
			} 
			
			else if (strPath.equals("/transfer.do")) {

				String userName = (String) session.getAttribute("USERNAME");

				String strdacc = req.getParameter("dacc");
				String stramt = req.getParameter("amt");

				double amt = Double.parseDouble(stramt);

				double remBalance = loginService.transferAmount(userName,
						strdacc, amt);

				if (remBalance == 0) {
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/transferfailure.jsp");
					requestDispatcher.forward(req, res);

				} else {
					session = req.getSession();
					session.setAttribute("REMBALANCE", remBalance);

					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/confirm.jsp");
					requestDispatcher.forward(req, res);
				}
			}
			else if(strPath.equals("/confirmhome.do"))
			{
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/transferred.jsp");
				requestDispatcher.forward(req, res);
			
			}

			else if (strPath.equals("/successhome.do"))

			{
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/success.jsp");
				requestDispatcher.forward(req, res);

			} 
			else if (strPath.equals("/withdraw.do")) {
				String strWAmount = req.getParameter("wamt");
				double withdrawAmt = Double.parseDouble(strWAmount);
				
				String userName = (String) session.getAttribute("USERNAME");

				double remBalance = loginService.withdrawAmount(userName,withdrawAmt);

				if (remBalance == 0) {
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/transferfailure.jsp");
					requestDispatcher.forward(req, res);

				} else{
					
					session.setAttribute("REMBALANCE", remBalance);
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/withdrawsuccess.jsp");
					requestDispatcher.forward(req, res);
				}
			}

			else if (strPath.equals("/delete.do")) {
				int i = 0;
				String struserName = req.getParameter("nme");
				String strAccno = req.getParameter("accno");
				String strPhone = req.getParameter("ph");


				double remBalance = (Double) session.getAttribute("REMBALANCE");
				req.setAttribute("REMBALANCE",remBalance);
				
				i = loginService.delete(struserName, strAccno, strPhone);
			
				if (i == 1)
				{			
					session.invalidate();
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/deletesuccess.jsp");
					requestDispatcher.forward(req, res);
				} 
				else 
				{
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/deletefailure.jsp");
					requestDispatcher.forward(req, res);
				}

			}
			else if (strPath.equals("/logout.do"))
			{
				
				RequestDispatcher requestDispatcher = req
						.getRequestDispatcher("./jsp/logout.jsp");
				requestDispatcher.forward(req, res);

			} 
			else if (strPath.equals("/ministatement.do"))
			{
				String userName = (String) session.getAttribute("USERNAME");
				double rembalance  =(Double) session.getAttribute("REMBALANCE");
				String accno1 = (String) session.getAttribute("ACCNO");			
				StringBuffer accno2 = new StringBuffer(accno1);
				accno2.replace(4, 8, "XXXXX");
				String accno = accno2.toString();
				
				req.setAttribute("REMBALANCE",rembalance);
				req.setAttribute("ACCNO", accno);
			
				List ministlist = loginService.miniStatement(userName);		
				req.setAttribute("MINISTLIST", ministlist);
				System.out.println("*******)))))))))))))))))))))))))))))HAPPY ENDING))))))))))))))))))))))))))");
				
				if (ministlist == null)
				{			
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/ministatementfailure.jsp");
					requestDispatcher.forward(req, res);
				} 
				else 
				{
					RequestDispatcher requestDispatcher = req
							.getRequestDispatcher("./jsp/ministatementsuccess.jsp");
					requestDispatcher.forward(req, res);
				}
			}			
		} 
		catch (SQLException e)
		{
			System.out.println("Please enter proper query");
		}
	}
}
