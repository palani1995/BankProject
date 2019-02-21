package com.cluster.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("Inside filter2 init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException
			
	{
		System.out.println("Inside filter2 dofilter()");
		String strAdd = req.getParameter("add");
		String strCity = req.getParameter("city");
		String strState = req.getParameter("state");
		String strPincode = req.getParameter("pincode");
		String strPhone = req.getParameter("ph");
		String strAphone = req.getParameter("aph");
		String strEmail = req.getParameter("email");
		
		if((strAdd !=null) &&(strCity!=null)&& (strState !=null)&&
				(strPincode !=null)&& (strPhone !=null) && (strAphone !=null) &&
				(strEmail!= null))
		{
			fc.doFilter(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("./jsp/proffailure.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	public void destroy() 
	{
		System.out.println("Inside filter2 destroy()");
	}

}
