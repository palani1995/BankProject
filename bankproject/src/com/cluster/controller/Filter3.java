package com.cluster.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter3 implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("Inside filter3 init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException
			
	{
		System.out.println("Inside filter3 dofilter()");
		String strFteacher = req.getParameter("ans1");
		String strFpet = req.getParameter("ans2");
		String strFschool = req.getParameter("ans3");
		String strChkbox = req.getParameter("chkbox");
		String accept = "accepted";
		
		
		if((strFteacher !=null) &&(strFpet!=null)&& (strFschool !=null)&&
				(strChkbox !=null))
		{
			if(strChkbox.equals(accept))
			{
				fc.doFilter(req, res);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("./jsp/securityfailure2.jsp");
				rd.forward(req, res);
			}
		}
		
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("./jsp/securityfailure1.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	public void destroy() 
	{
		System.out.println("Inside filter2 destroy()");
	}
}
