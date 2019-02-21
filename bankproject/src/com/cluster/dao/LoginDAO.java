package com.cluster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import oracle.net.ns.SessionAtts;

import com.cluster.to.MiniStatementInfoTO;
import com.cluster.to.NewUserInfoTO;
import com.cluster.to.NewUserSecurityInfoTO;
import com.cluster.util.DBUtil;

public class LoginDAO {
	Connection connection;

	public LoginDAO() throws ClassNotFoundException, SQLException {
		connection = DBUtil.getOracleConnection();
	}

	public boolean verifyUserName(String userName) throws SQLException {
		System.out.println("Inside verifyuserName()");
		boolean b = false;
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();
		try {
			preparedstatement = connection
					.prepareStatement("SELECT USERNAME FROM CUSTOMER");
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				if (userName1.equals(resultSet.getString("USERNAME"))) {
					return b = true;
				} else {
					return b;
				}
			}

		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
		}
		return b;
	}

	public NewUserSecurityInfoTO newUserRegister(NewUserInfoTO userInfoTO)
			throws SQLException {
		System.out.println("Inside newuserregister()");
		int i = 0;
		NewUserSecurityInfoTO nSecurityInfoTO = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement2 = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("INSERT INTO CUSTOMER(CUSTOMER_ID,ACCNO,PIN,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,AGE,DOB,SEX,ADDRESS,CITY,STATE,PINCODE,PHONE_NO,ALTERNATE_PHONE_NO,EMAIL_ID,FAV_TEACHER,FAV_PET,FIRST_SCHOOL,AMOUNT,CREATED_DATE)VALUES(CUSTOMER_ID_SEQ.NEXTVAL,ACCNO_SEQ.NEXTVAL,PIN_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, userInfoTO.getFirstName()
					.toUpperCase());
			preparedStatement.setString(2, userInfoTO.getLastName()
					.toUpperCase());
			preparedStatement.setString(3, userInfoTO.getUserName()
					.toUpperCase());

			preparedStatement.setString(4, userInfoTO.getPassword()
					.toUpperCase());

			preparedStatement.setInt(5, userInfoTO.getAge());

			Date utildate = userInfoTO.getDob();
			java.sql.Date sqldate = new java.sql.Date(utildate.getTime());

			preparedStatement.setDate(6, sqldate);
			preparedStatement
					.setString(7, userInfoTO.getGender().toUpperCase());
			preparedStatement.setString(8, userInfoTO.getAddress()
					.toUpperCase());
			preparedStatement.setString(9, userInfoTO.getCity().toUpperCase());
			preparedStatement
					.setString(10, userInfoTO.getState().toUpperCase());
			preparedStatement.setLong(11, userInfoTO.getPincode());
			preparedStatement.setString(12, userInfoTO.getPhoneNo()
					.toUpperCase());
			preparedStatement.setString(13, userInfoTO.getAPhoneNo()
					.toUpperCase());
			preparedStatement
					.setString(14, userInfoTO.getEmail().toUpperCase());
			preparedStatement.setString(15, userInfoTO.getAns1().toUpperCase());
			preparedStatement.setString(16, userInfoTO.getAns2().toUpperCase());
			preparedStatement.setString(17, userInfoTO.getAns3().toUpperCase());
			preparedStatement.setDouble(18, 0.0);
			Date utildate1 = new Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(
					utildate1.getTime());
			preparedStatement.setTimestamp(19, timestamp);

			i = preparedStatement.executeUpdate();

			preparedStatement2 = connection
					.prepareStatement("SELECT USERNAME,ACCNO,AMOUNT,PIN FROM CUSTOMER WHERE USERNAME = ?");
			preparedStatement2.setString(1, userInfoTO.getUserName()
					.toUpperCase());
			resultSet = preparedStatement2.executeQuery();

			while (resultSet.next()) {
				String userName = resultSet.getString("USERNAME");
				String accno = resultSet.getString("ACCNO");
				double amount = resultSet.getDouble("AMOUNT");
				int pin = resultSet.getInt("PIN");

				nSecurityInfoTO = new NewUserSecurityInfoTO();
				nSecurityInfoTO.setUserName(userName);
				nSecurityInfoTO.setAccno(accno);
				nSecurityInfoTO.setPin(pin);
				nSecurityInfoTO.setAmount(amount);
			}
			if ((i == 1)) {
				preparedStatement1 = connection
						.prepareStatement("INSERT INTO MINISTATEMENTOFSBM(USERNAME,TRANSACTIONDATE,TRANSACTIONAMOUNT)VALUES(?,?,?)");
				preparedStatement1.setString(1, userInfoTO.getUserName()
						.toUpperCase());
				preparedStatement1.setTimestamp(2, timestamp);
				preparedStatement1.setDouble(3, 0.0);
				int x = preparedStatement1.executeUpdate();
				if (x == 1) {
					connection.commit();
					return nSecurityInfoTO;
				}
			} else {
				connection.rollback();
			}

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (preparedStatement1 != null) {
				preparedStatement1.close();
			}
			if (preparedStatement2 != null) {
				preparedStatement2.close();
			}
		}
		return nSecurityInfoTO;
	}

	public boolean verify(String userName, String password) throws SQLException {
		System.out.println("Inside verify()");
		boolean b = false;
		Statement statement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();
		String password1 = password.toUpperCase();

		try {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT USERNAME,PASSWORD FROM CUSTOMER");

			while (resultSet.next()) {
				if ((userName1.equals(resultSet.getString("USERNAME")))
						&& (password1.equals(resultSet.getString("PASSWORD")))) {
					b = true;
				}
			}
			return b;

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}

		}
	}

	public boolean pinVerify(String pin, String userName) throws SQLException {
		System.out.println("Inside pinverify()");
		boolean b = false;
		Statement statement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();

		try {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT USERNAME,PIN FROM CUSTOMER");

			while (resultSet.next()) {
				if (pin.equals(resultSet.getString("PIN"))
						&& (userName1.equals(resultSet.getString("USERNAME")))) {
					b = true;
				}

			}
			return b;
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	public String getaccno(String userName) throws SQLException {
		System.out.println("Inside getaccno()");
		String accno = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT ACCNO FROM CUSTOMER WHERE USERNAME = ?");
			preparedStatement.setString(1, userName1);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				accno = resultSet.getString("ACCNO");
			}
			return accno;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	public double getamount(String userName) throws SQLException {
		System.out.println("Inside getamount()");
		double amount = 0.0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT AMOUNT FROM CUSTOMER WHERE USERNAME = ?");
			preparedStatement.setString(1, userName1);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				amount = resultSet.getDouble("AMOUNT");
			}
			return amount;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	public double checkBalance(String userName) throws SQLException {
		System.out.println("Inside checkbalance()");
		double d = 0;
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();
		try {

			preparedstatement = connection
					.prepareStatement(
							"SELECT AMOUNT FROM CUSTOMER WHERE USERNAME = ?",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedstatement.setString(1, userName1);
			resultSet = preparedstatement.executeQuery();
			resultSet.next();
			d = resultSet.getDouble("AMOUNT");
			return d;
		} finally {
			if (preparedstatement != null) {
				preparedstatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}

		}
	}

	public double depositAmt(double dAmount, String accNo) throws SQLException {
		System.out.println("Inside depositAmt()");
		double sAmount = 0.0;
		double AVamount = 0.0;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;

		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		String userName = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement1 = connection
					.prepareStatement(
							"SELECT AMOUNT,USERNAME FROM CUSTOMER WHERE ACCNO = ?",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement1.setString(1, accNo);

			resultSet1 = preparedStatement1.executeQuery();
			if (resultSet1.next())
				;
			{
				userName = resultSet1.getString("USERNAME");
				sAmount = resultSet1.getDouble("AMOUNT");
				AVamount = sAmount + dAmount;
			}
			preparedStatement2 = connection
					.prepareStatement("UPDATE CUSTOMER SET AMOUNT = ? WHERE ACCNO = ?");
			preparedStatement2.setDouble(1, AVamount);
			preparedStatement2.setString(2, accNo);

			int i = preparedStatement2.executeUpdate();

			preparedStatement1.setString(1, accNo);
			resultSet2 = preparedStatement1.executeQuery();
			if (resultSet2.next()) {
				AVamount = resultSet2.getDouble("AMOUNT");
			}
			connection.commit();

			Date utildate1 = new Date();
			System.out.println("utildate1  " + utildate1);
			java.sql.Timestamp timestamp = new java.sql.Timestamp(
					utildate1.getTime());
			System.out.println("timestampo1    " + timestamp);

			preparedStatement3 = connection
					.prepareStatement(
							"INSERT INTO MINISTATEMENTOFSBM(USERNAME,TRANSACTIONDATE,TRANSACTIONAMOUNT)VALUES(?,?,?)",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement3.setString(1, userName.toUpperCase());
			preparedStatement3.setTimestamp(2, timestamp);
			preparedStatement3.setDouble(3, dAmount);

			int x = preparedStatement3.executeUpdate();

		} catch (SQLException e) {
			connection.rollback();
			System.out.println("Error in transaction process");
		} finally {
			if (preparedStatement1 != null) {
				preparedStatement1.close();
			}
			if (preparedStatement2 != null) {
				preparedStatement2.close();
			}
			if (preparedStatement3 != null) {
				preparedStatement3.close();
			}
			if (resultSet1 != null) {
				resultSet1.close();
			}
			if (resultSet2 != null) {
				resultSet2.close();
			}
		}
		return AVamount;
	}

	public double transferAmt(String userName, String dacc, double amt)
			throws SQLException {
		System.out.println("Inside transferAmt()");
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet3 = null;
		String sacc = null;
		double samt = 0, dnbal, damt = 0, remBalance = 0;
		double s = 0;
		String userName1 = userName.toUpperCase();
		try {
			connection.setAutoCommit(false);
			preparedStatement1 = connection
					.prepareStatement(
							"SELECT AMOUNT,ACCNO FROM CUSTOMER WHERE USERNAME =?",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement1.setString(1, userName1);
			resultSet1 = preparedStatement1.executeQuery();

			while (resultSet1.next()) {
				samt = resultSet1.getDouble("AMOUNT");
				sacc = resultSet1.getString("ACCNO");
			}

			if (samt >= amt) {
				remBalance = samt - amt;
			} else {
				throw new Exception();
			}

			preparedStatement2 = connection
					.prepareStatement("UPDATE CUSTOMER SET AMOUNT = ? WHERE ACCNO = ? ");
			preparedStatement2.setDouble(1, remBalance);
			preparedStatement2.setString(2, sacc);
			preparedStatement2.executeUpdate();

			preparedStatement3 = connection
					.prepareStatement("SELECT AMOUNT FROM CUSTOMER WHERE ACCNO =?");
			preparedStatement3.setString(1, dacc);
			resultSet3 = preparedStatement3.executeQuery();
			if (resultSet3.next()) {
				damt = resultSet3.getDouble("AMOUNT");
			}
			dnbal = damt + amt;

			preparedStatement2.setDouble(1, dnbal);
			preparedStatement2.setString(2, dacc);
			preparedStatement2.executeUpdate();

			connection.commit();

			Date utildate1 = new Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(
					utildate1.getTime());

			preparedStatement3 = connection
					.prepareStatement(
							"INSERT INTO MINISTATEMENTOFSBM(USERNAME,TRANSACTIONDATE,TRANSACTIONAMOUNT)VALUES(?,?,?)",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement3.setString(1, userName1);
			preparedStatement3.setTimestamp(2, timestamp);
			preparedStatement3.setDouble(3, amt);

			int x = preparedStatement3.executeUpdate();
		}

		catch (Exception e) {
			try {
				connection.rollback();
				System.out.println("NO sufficient Balance");
				return s;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (preparedStatement1 != null) {
				preparedStatement1.close();
			}
			if (preparedStatement2 != null) {
				preparedStatement2.close();
			}
			if (preparedStatement3 != null) {
				preparedStatement3.close();
			}
			if (resultSet1 != null) {
				resultSet1.close();
			}
			if (resultSet3 != null) {
				resultSet3.close();
			}
		}
		return remBalance;
	}

	public double withdrawAmt(String userName, double withdrawAmt)
			throws SQLException {
		System.out.println("Inside withdrawamt()");
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		double samt = 0, remBalance = 0, s = 0;
		String userName1 = userName.toUpperCase();
		try {
			connection.setAutoCommit(false);
			preparedStatement1 = connection
					.prepareStatement(
							"SELECT AMOUNT FROM CUSTOMER WHERE USERNAME =?",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement1.setString(1, userName1);
			resultSet1 = preparedStatement1.executeQuery();

			if (resultSet1.next()) {
				samt = resultSet1.getDouble("AMOUNT");
			}
			if (withdrawAmt < samt) {
				remBalance = samt - withdrawAmt;
			} else

			{
				throw new Exception();
			}

			preparedStatement2 = connection
					.prepareStatement("UPDATE CUSTOMER SET AMOUNT = ? WHERE USERNAME = ? ");
			preparedStatement2.setDouble(1, remBalance);
			preparedStatement2.setString(2, userName1);
			preparedStatement2.executeUpdate();

			connection.commit();

			Date utildate1 = new Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(
					utildate1.getTime());

			preparedStatement3 = connection
					.prepareStatement(
							"INSERT INTO MINISTATEMENTOFSBM(USERNAME,TRANSACTIONDATE,TRANSACTIONAMOUNT)VALUES(?,?,?)",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			preparedStatement3.setString(1, userName1);
			preparedStatement3.setTimestamp(2, timestamp);
			preparedStatement3.setDouble(3, withdrawAmt);

			int x = preparedStatement3.executeUpdate();

		} catch (Exception e) {
			try {
				connection.rollback();
				System.out.println("NO sufficient Balance");
				return s;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (preparedStatement1 != null) {
				preparedStatement1.close();
			}
			if (preparedStatement2 != null) {
				preparedStatement2.close();
			}
			if (resultSet1 != null) {
				resultSet1.close();
			}

		}
		return remBalance;
	}

	public int deleteAccount(String userName, String accNo, String phone)
			throws SQLException {
		System.out.println("Inside deleteAccount()");
		PreparedStatement preparedStatement1 = null;
		int i = 0;
		String userName1 = userName.toUpperCase();

		try {
			connection.setAutoCommit(false);

			preparedStatement1 = connection
					.prepareStatement("DELETE FROM CUSTOMER WHERE USERNAME =? AND ACCNO = ? AND PHONE_NO =?");
			preparedStatement1.setString(1, userName1);
			preparedStatement1.setString(2, accNo);
			preparedStatement1.setString(3, phone);
			i = preparedStatement1.executeUpdate();

			if (i == 1) {
				System.out.println("deleted " + i);
			} else {
				throw new Exception();
			}
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				System.out.println("Incorrect Details cannot proceed delete");
				return 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (preparedStatement1 != null) {
				preparedStatement1.close();
			}

		}
		return i;
	}

	public List miniStatement(String userName) throws SQLException {
		System.out.println("Inside ministatement()");
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String userName1 = userName.toUpperCase();

		List<MiniStatementInfoTO> ministList = new ArrayList<MiniStatementInfoTO>(
				10);
		MiniStatementInfoTO mInfoTO = null;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM MINISTATEMENTOFSBM WHERE USERNAME = ? ORDER BY TRANSACTIONDATE DESC");
			preparedStatement.setString(1, userName1);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				double transactionamount = resultSet
						.getDouble("TRANSACTIONAMOUNT");

				Timestamp timeanddate = resultSet
						.getTimestamp("TRANSACTIONDATE");

				mInfoTO = new MiniStatementInfoTO();
				mInfoTO.setDateandtime(timeanddate);
				mInfoTO.setTransactionamount(transactionamount);

				ministList.add(mInfoTO);

			}
			return ministList;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}

		}
	}

	public void finalize() {
		System.out.println("Inside finalize()");
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error in closing object level resource");
				e.printStackTrace();
			}
		}
	}
}
