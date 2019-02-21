package com.cluster.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import com.cluster.dao.LoginDAO;

import com.cluster.to.MiniStatementInfoTO;
import com.cluster.to.NewUserInfoTO;
import com.cluster.to.NewUserSecurityInfoTO;

public class LoginService 
{
	LoginDAO logindao;
	
	public LoginService() throws ClassNotFoundException, SQLException
	{
		logindao = new LoginDAO();		
	}
	public boolean checkUserName(String userName) throws SQLException
	{
		boolean b = logindao.verifyUserName(userName);
		return b;
	}
	public NewUserSecurityInfoTO newUserRegister(NewUserInfoTO userInfoTO) throws SQLException
	{
		NewUserSecurityInfoTO nSecurityInfoTO = logindao.newUserRegister(userInfoTO);
		return nSecurityInfoTO;
	}
	public boolean check(String userName,String password) throws SQLException
	{
		boolean b = logindao.verify(userName,password);
		return b;
	}
	public boolean pinVerify(String pin,String userName) throws SQLException
	{
		boolean b = logindao.pinVerify(pin,userName);
		return b;
	}
	public String getaccno(String userName) throws SQLException
	{
		String accno = logindao.getaccno(userName);
		return accno;
	}
	public double getamount(String userName) throws SQLException
	{
		double amount = logindao.getamount(userName);
		return amount;
	
		
	}
	public double balanceInfo(String userName) throws SQLException
	{
		double d = logindao.checkBalance(userName);
		return d;
	}
	public double depositAmount(double dAmount , String accNo) throws SQLException
	{
		double AVamount = logindao.depositAmt(dAmount , accNo);
		return AVamount;
	}
	public double transferAmount(String userName , String dacc ,double amt ) throws SQLException
	{
		double remBalance = logindao.transferAmt(userName,dacc,amt);
		return remBalance;
	}
	public double withdrawAmount(String userName , double withdrawAmt) throws SQLException
	{
		double remBalance = logindao.withdrawAmt(userName,withdrawAmt);
		return remBalance;
	}
	public int delete(String userName ,String accNo,String phone) throws SQLException
	{
	    int i = logindao.deleteAccount(userName,accNo,phone);
		return i;
	}
	public List miniStatement(String userName) throws SQLException
	{
		List ministlist = logindao.miniStatement(userName);
		return ministlist;
	}

}
