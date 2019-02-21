package com.cluster.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter
{ @Override
	public void init(FilterConfig arg0) throws ServletException {
	System.out.println("inside filter1 init()");
	
     }
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException
			
	{
		String strFname = req.getParameter("fname");
		String strLname = req.getParameter("lname");
		String strUname = req.getParameter("uname");
		String strPwd = req.getParameter("pwd");
		String strRpwd = req.getParameter("rpwd");
		String strDate = req.getParameter("dob");
		String strAge = req.getParameter("age");
		String strGender=req.getParameter("gender");
		
		if((strFname !=null) &&(strLname!=null)&& (strUname !=null)&&
				(strPwd !=null)&& (strRpwd !=null) && (strDate !=null) &&
				(strAge!= null) && (strGender!=null))
		{
			System.out.println("inside filter1 dofilter()");
			
			if(strPwd.equals(strRpwd))
			{
				fc.doFilter(req, res);	
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("./jsp/personalfailure2.jsp");
				rd.forward(req, res);
			}
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("./jsp/personalfailure1.jsp");
			rd.forward(req, res);
		}
	}
	@Override
	public void destroy() {
		System.out.println("inside  filter1 destroy()");
		
	}

	
}
