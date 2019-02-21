package com.cluster.to;

import java.sql.Timestamp;
import java.util.Date;

public class MiniStatementInfoTO 
{
	Timestamp dateandtime;
	double transactionamount;
	
	
	public Timestamp getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(Timestamp dateandtime) {
		this.dateandtime = dateandtime;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	
	
	

}
